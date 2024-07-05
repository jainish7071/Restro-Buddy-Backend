package com.app.restrobuddy.Service.Order;

import com.app.restrobuddy.Entity.OrderEntity;
import com.app.restrobuddy.Service.BaseService;
import com.app.restrobuddy.Shared.Dtos.OrderDto;

public interface OrderService extends BaseService<OrderEntity, OrderDto> {
    OrderDto saveOrder(OrderDto order);
}
