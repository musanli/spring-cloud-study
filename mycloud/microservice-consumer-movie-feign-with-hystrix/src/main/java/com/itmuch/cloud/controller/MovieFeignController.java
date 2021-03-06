package com.itmuch.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.itmuch.cloud.entity.User;
import com.itmuch.cloud.feign.UserFeignClient;

@RestController
public class MovieFeignController {
//http://localhost:8020/movid/1
	@Autowired
	UserFeignClient UserFeignClient;

	@GetMapping("/movie/{id}")
	public User findById(@PathVariable Long id) {
		return UserFeignClient.findById(id);
	}

}
