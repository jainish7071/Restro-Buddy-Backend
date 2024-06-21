package com.app.restrobuddy.Shared.Dtos;

import lombok.Data;

@Data
public class OrderItemDto {
    private Long id;
    private MenuItemDto item;
    private int count;
}
