package com.itmuch.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.itmuch.cloud.entity.User;

import ch.qos.logback.core.net.SyslogOutputStream;

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
	public User findById(@PathVariable Long id) {
		System.out.println("消费者服务");
		ServiceInstance serviceInstance = loadBalancerClient.choose("microservice-provider-user");
		System.out.println("user : "+serviceInstance.getHost() + ": " + serviceInstance.getPort() + ": " + serviceInstance.getServiceId());
		return restTemplate.getForObject("http://microservice-provider-user/simple/" + id, User.class);
	}

	// http:localhost:7901/testmovie/2
	@GetMapping("/testmovie/{id}")
	public String test(@PathVariable Long id) {
		System.out.println("测试消费者服务");
		System.out.println("id = " + id);
		return "你好" + id;
	}

	@Autowired
	private LoadBalancerClient loadBalancerClient;

	@GetMapping("/test")
	public String test() {
		ServiceInstance serviceInstance = loadBalancerClient.choose("microservice-provider-user");
		System.out.println("user : "+serviceInstance.getHost() + ": " + serviceInstance.getPort() + ": " + serviceInstance.getServiceId());
		
		
		ServiceInstance serviceInstance_copy = loadBalancerClient.choose("microservice-provider-user2");
		System.out.println("user-copy : "+serviceInstance_copy.getHost() + ": " + serviceInstance_copy.getPort() + ": " + serviceInstance_copy.getServiceId());
		return "1";
	}
}
