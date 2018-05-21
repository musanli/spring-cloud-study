package com.itmuch.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itmuch.cloud.entity.User;

@FeignClient(name = "microservice-provider-user", fallback = MyHystrixClietnFallback.class )
public interface UserFeignClient {

	@RequestMapping(value = "/simple/{id}", method = RequestMethod.GET)
	public User findById(@PathVariable("id") Long id);

}

@Component
class MyHystrixClietnFallback implements UserFeignClient{

	@Override
	public User findById(Long id) {
		User user = new User();
		user.setAge((short) 20);
		user.setName("努尔哈赤");
		System.out.println("哈哈哈进来了.......");
		return user;
	}
	
}