package com.app.restrobuddy.Shared.Dtos;

import com.app.restrobuddy.Shared.Enum.ItemType;
import lombok.Data;


@Data
public class MenuItemDto {
    private Long id;

    private String name;

    private String description;

    private Double price;

    private int discount;

    private String imageUrl;

    private boolean isRecommended;

    private int timeToPrepare;

    private boolean isAvailable;

    private boolean isActive;

    private ItemType itemType;
}
