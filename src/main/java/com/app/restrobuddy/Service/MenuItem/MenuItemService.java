package com.app.restrobuddy.Service.MenuItem;

import com.app.restrobuddy.Entity.MenuItemEntity;
import com.app.restrobuddy.Service.BaseService;
import com.app.restrobuddy.Shared.Dtos.MenuItemDto;

import java.util.List;

public interface MenuItemService extends BaseService<MenuItemEntity, MenuItemDto> {
    List<MenuItemDto> getMenuItems();

    MenuItemDto addMenuItem(MenuItemDto item);
}
