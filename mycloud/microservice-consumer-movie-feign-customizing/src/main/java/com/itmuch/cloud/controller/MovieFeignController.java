package com.itmuch.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.itmuch.cloud.entity.User;
import com.itmuch.cloud.feign.FeignClientTwo;
import com.itmuch.cloud.feign.UserFeignClient;

@RestController
public class MovieFeignController {

	@Autowired
	UserFeignClient UserFeignClient;
	@Autowired
	FeignClientTwo freignClientTwo;
	
	@GetMapping("/movie/{id}")
	public User findById(@PathVariable Long id) {
		return UserFeignClient.findById(id);
	}

	@GetMapping("/{serviceName}")
	public String findServerInfoForServerName(@PathVariable("serviceName") String serviceName) {
	return this.freignClientTwo.findServerInfoForServerName(serviceName);
	}
}
