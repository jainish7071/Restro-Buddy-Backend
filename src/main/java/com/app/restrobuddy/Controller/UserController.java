package com.app.restrobuddy.Controller;

import com.app.restrobuddy.FeignClient.UserFeignClient;
import com.app.restrobuddy.Shared.Dtos.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserFeignClient userFeignClient;

    @Autowired
    public UserController(UserFeignClient feignClient){
        this.userFeignClient = feignClient;
    }


    @GetMapping("/findAll")
    public List<UserDto> findAll(){
        return userFeignClient.getAllUser();
    }
}
