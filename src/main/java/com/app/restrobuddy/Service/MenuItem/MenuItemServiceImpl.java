package com.app.restrobuddy.Service.MenuItem;

import com.app.restrobuddy.Entity.MenuItem;
import com.app.restrobuddy.Repository.MenuItemRepository;
import com.app.restrobuddy.Shared.Dtos.MenuItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuItemServiceImpl implements MenuItemService {

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Override
    public List<MenuItemDto> getMenuItems() {
        List<MenuItem> menuItems = menuItemRepository.findAll();
        return menuItems.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private MenuItemDto convertToDto(MenuItem menuItem) {
        MenuItemDto menuItemDto = new MenuItemDto();
        menuItemDto.setId(menuItem.getId());
        menuItemDto.setName(menuItem.getName());
        menuItemDto.setDescription(menuItem.getDescription());
        menuItemDto.setPrice(menuItem.getPrice());
        menuItemDto.setDiscount(menuItem.getDiscount());
        menuItemDto.setImageUrl(menuItem.getImageUrl());
        menuItemDto.setRecommended(menuItem.isRecommended());
        menuItemDto.setTimeToPrepare(menuItem.getTimeToPrepare());
        menuItemDto.setAvailable(menuItem.isAvailable());
        menuItemDto.setActive(menuItem.isActive());
        menuItemDto.setItemType(menuItem.getItemType());
        return menuItemDto;
    }
}
