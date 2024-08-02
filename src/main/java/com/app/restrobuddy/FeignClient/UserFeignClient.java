package com.app.restrobuddy.FeignClient;


import com.app.restrobuddy.Shared.Dtos.LoginDto;
import com.app.restrobuddy.Shared.Dtos.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name="user-client", url = "http://localhost:8081/user/")
public interface UserFeignClient {
    @PostMapping("/saveUser")
    UserDto saveUser(@RequestBody UserDto user);

    @GetMapping("/getUser/{userId}")
    UserDto getUser(@PathVariable Long userId);

    @DeleteMapping("/deleteUser/{userId}")
    boolean deleteUser(@PathVariable Long userId);

    @GetMapping("/getAllUser")
    List<UserDto> getAllUser();

    @PostMapping("/login")
    UserDto login(@RequestBody LoginDto loginDto);
}
