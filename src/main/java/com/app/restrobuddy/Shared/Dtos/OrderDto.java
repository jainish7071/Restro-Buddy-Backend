package com.app.restrobuddy.Shared.Dtos;

import com.app.restrobuddy.Shared.Enum.OrderStatus;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderDto {
    private Long id;
    private String tableId;
    private String paymentId;
    private Date orderTime;
    private int estimatedTime;
    private Date deliveredTime;
    private Long totalPrice;
    private Long discountedPrice;
    private OrderStatus orderStatus;
    private List<OrderItemDto> items;
}
