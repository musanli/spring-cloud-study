package com.itmuch.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.itmuch.cloud.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * http://localhost:8010/movie/1
 * 
 * @author li_bin
 *
 */
@RestController
public class MovieCoontroller {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/movie/{id}")
	@HystrixCommand(fallbackMethod="findByIdFallBack")
	public User findById(@PathVariable Long id) {
		System.out.println("消费者服务");
		// http://localhost:7901/simple/
		return restTemplate.getForObject("http://microservice-provider-user/simple/" + id, User.class);
	}
	
	public User findByIdFallBack(Long id) {
		System.out.println("方法出错进入.....fallback");
		User user = new User();
		user.setId(id);
		return user;
	}
	
	
}
