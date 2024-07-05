package com.app.restrobuddy.Service.Order;

import com.app.restrobuddy.Entity.OrderEntity;
import com.app.restrobuddy.Repository.OrderRepository;
import com.app.restrobuddy.Shared.Dtos.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderDto saveOrder(OrderDto order) {
        return null;
    }

    @Override
    public OrderDto copyToDto(OrderEntity entity) {
        return null;
    }

    @Override
    public OrderEntity copyFromDto(OrderDto dto) {
        OrderEntity entity = orderRepository.findById(dto.getId()).orElse(null);
        if(Objects.isNull(entity)){}
        return null;
    }
}
