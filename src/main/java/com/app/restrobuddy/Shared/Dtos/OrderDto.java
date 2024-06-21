package com.app.restrobuddy.Shared.Dtos;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderDto {
    private Long id;
    private String table_id;
    private String paymentId;
    private Date orderTime;
    private int estimatedTime;
    private List<OrderItemDto> items;
}
