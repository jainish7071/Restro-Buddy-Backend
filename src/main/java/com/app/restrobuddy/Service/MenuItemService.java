package com.app.restrobuddy.Service;

import com.app.restrobuddy.Shared.Dtos.MenuItemDto;

import java.util.List;

public interface MenuItemService {
    List<MenuItemDto> getMenuItems();
}
