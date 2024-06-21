package com.app.restrobuddy.Controller;


import com.app.restrobuddy.Service.MenuItem.MenuItemService;
import com.app.restrobuddy.Shared.Dtos.MenuItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu-item")
@CrossOrigin(origins = "*")
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    @GetMapping(path = "/findAll")
    public List<MenuItemDto> getMenuItems(){
        return menuItemService.getMenuItems();
    }
}
