package com.app.restrobuddy.Controller;

import com.app.restrobuddy.FeignClient.UserFeignClient;
import com.app.restrobuddy.Shared.Dtos.LoginDto;
import com.app.restrobuddy.Shared.Dtos.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserFeignClient userFeignClient;

    @Autowired
    public UserController(UserFeignClient feignClient){
        this.userFeignClient = feignClient;
    }

    @PostMapping("/save-user")
    public UserDto saveUser(@RequestBody UserDto userDto){
        return userFeignClient.saveUser(userDto);
    }

    @PostMapping("/login")
    public UserDto login(@RequestBody LoginDto loginDto){
        return userFeignClient.login(loginDto);
    }
}
