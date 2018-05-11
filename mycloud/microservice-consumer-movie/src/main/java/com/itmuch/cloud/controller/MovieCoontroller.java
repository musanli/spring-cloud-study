package com.itmuch.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.itmuch.cloud.entity.User;

@RestController
public class MovieCoontroller {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/movie/{id}")
	public User findById(@PathVariable Long id) {
		System.out.println("消费者服务");
		return restTemplate.getForObject("http://localhost:7901/simple/"+id, User.class);
	}
	//http:localhost:7901/testmovie/2
	@GetMapping("/testmovie/{id}")
	public String test(@PathVariable Long id) {
		System.out.println("测试消费者服务");
		System.out.println("id = "+id);
		return "你好"+id;
	}
}
