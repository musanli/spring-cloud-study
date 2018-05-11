package com.itmuch.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.itmuch.cloud.entity.User;
import com.itmuch.config.ConfigurationCustomizing;

import feign.Param;
import feign.RequestLine;

@FeignClient(name = "microservice-provider-user", configuration=ConfigurationCustomizing.class)
public interface UserFeignClient {

	@RequestLine("GET /simple/{id}")
	public User findById(@Param("id") Long id);

}
