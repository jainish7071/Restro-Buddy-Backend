package com.app.restrobuddy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.CrossOrigin;

@EnableFeignClients(basePackages = "com.app.restrobuddy.FeignClient")
@SpringBootApplication
public class RestroBuddyApplication {
	public static void main(String[] args) {
		SpringApplication.run(RestroBuddyApplication.class, args);
	}

}
