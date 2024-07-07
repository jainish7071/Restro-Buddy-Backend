package com.app.restrobuddy.Shared.Dtos;

import lombok.Data;

@Data
public class OrderItemDto {
    private Long orderId;
    private MenuItemDto item;
    private int count;
    public OrderItemDto(Long orderId, MenuItemDto item, int count){
        this.orderId = orderId;
        this.item = item;
        this.count = count;
    }
}
