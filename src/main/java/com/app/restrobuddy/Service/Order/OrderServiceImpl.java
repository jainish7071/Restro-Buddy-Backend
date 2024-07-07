package com.app.restrobuddy.Service.Order;

import com.app.restrobuddy.Entity.MenuItemEntity;
import com.app.restrobuddy.Entity.OrderEntity;
import com.app.restrobuddy.Entity.OrderItemEntity;
import com.app.restrobuddy.Entity.OrderItemEntityKey;
import com.app.restrobuddy.Repository.MenuItemRepository;
import com.app.restrobuddy.Repository.OrderRepository;
import com.app.restrobuddy.Service.MenuItem.MenuItemService;
import com.app.restrobuddy.Shared.Dtos.OrderDto;
import com.app.restrobuddy.Shared.Dtos.OrderItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private MenuItemService menuItemService;

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Override
    public OrderDto placeOrder(OrderDto order) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity = copyFromDto(orderEntity, order);
        OrderEntity savedOrderEntity = orderRepository.save(orderEntity);
        return copyToDto(savedOrderEntity);
    }

    @Override
    public OrderDto getOrder(Long orderId) {
        Optional<OrderEntity> order = orderRepository.findById(orderId);
        return order.map(this::copyToDto).orElse(null);
    }

    @Override
    public OrderDto copyToDto(OrderEntity entity) {
        OrderDto dto = new OrderDto();
        dto.setId(entity.getId());
        dto.setTableId(entity.getTableId());
        dto.setPaymentId(entity.getPaymentId());
        dto.setOrderTime(entity.getOrderTime());
        dto.setDeliveredTime(entity.getDeliveredTime());
        dto.setEstimatedTime(entity.getEstimatedTime());
        dto.setTotalPrice(entity.getTotalPrice());
        dto.setDiscountedPrice(entity.getDiscountedPrice());
        dto.setOrderStatus(entity.getOrderStatus());
        List<OrderItemDto> orderItemDto = entity.getItems().stream()
                .map((OrderItemEntity orderItemEntity) -> new OrderItemDto(orderItemEntity.getOrder().getId(), menuItemService.copyToDto(orderItemEntity.getItem()), orderItemEntity.getItem_count()))
                .toList();
        dto.setItems(orderItemDto);
        return dto;
    }

    @Override
    public OrderEntity copyFromDto(OrderEntity entity, OrderDto dto) {
        entity.setId(dto.getId());
        entity.setTableId(dto.getTableId());
        entity.setPaymentId(dto.getPaymentId());
        entity.setOrderTime(dto.getOrderTime());
        entity.setDeliveredTime(dto.getDeliveredTime());
        entity.setEstimatedTime(dto.getEstimatedTime());
        entity.setTotalPrice(dto.getTotalPrice());
        entity.setDiscountedPrice(dto.getDiscountedPrice());
        entity.setOrderStatus(dto.getOrderStatus());
        List<OrderItemEntity> orderItemEntity = dto.getItems().stream().map((OrderItemDto orderItemDto) -> {
            MenuItemEntity menuItem = menuItemRepository.findById(orderItemDto.getItem().getId()).orElse(menuItemService.copyFromDto(new MenuItemEntity(), orderItemDto.getItem()));
            return new OrderItemEntity(new OrderItemEntityKey(entity.getId(), menuItem.getId()), entity, menuItem, orderItemDto.getCount());
        }).toList();
        entity.setItems(orderItemEntity);
        return entity;
    }
}
