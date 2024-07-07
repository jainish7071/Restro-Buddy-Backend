package com.app.restrobuddy.Service.MenuItem;

import com.app.restrobuddy.Entity.MenuItemEntity;
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
        List<MenuItemEntity> menuItemEntities = menuItemRepository.findAll();
        return menuItemEntities.stream().map(this::copyToDto).collect(Collectors.toList());
    }

    @Override
    public MenuItemDto addMenuItem(MenuItemDto item) {
        MenuItemEntity menuItem = new MenuItemEntity();
        copyFromDto(menuItem, item);
        MenuItemEntity savedMenuItem = menuItemRepository.save(menuItem);
        return copyToDto(savedMenuItem);
    }

    @Override
    public MenuItemDto copyToDto(MenuItemEntity entity) {
        MenuItemDto menuItemDto = new MenuItemDto();
        menuItemDto.setId(entity.getId());
        menuItemDto.setName(entity.getName());
        menuItemDto.setDescription(entity.getDescription());
        menuItemDto.setPrice(entity.getPrice());
        menuItemDto.setDiscount(entity.getDiscount());
        menuItemDto.setImageUrl(entity.getImageUrl());
        menuItemDto.setRecommended(entity.isRecommended());
        menuItemDto.setTimeToPrepare(entity.getTimeToPrepare());
        menuItemDto.setAvailable(entity.isAvailable());
        menuItemDto.setActive(entity.isActive());
        menuItemDto.setItemType(entity.getItemType());
        return menuItemDto;
    }

    @Override
    public MenuItemEntity copyFromDto(MenuItemEntity entity, MenuItemDto dto) {
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setDiscount(dto.getDiscount());
        entity.setImageUrl(dto.getImageUrl());
        entity.setRecommended(dto.isRecommended());
        entity.setTimeToPrepare(dto.getTimeToPrepare());
        entity.setAvailable(dto.isAvailable());
        entity.setActive(dto.isActive());
        entity.setItemType(dto.getItemType());
        return entity;
    }
}
