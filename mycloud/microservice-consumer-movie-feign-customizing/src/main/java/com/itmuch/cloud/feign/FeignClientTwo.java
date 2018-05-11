package com.itmuch.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itmuch.config.Configuration2;
@FeignClient(name="XXXX" ,url="http://localhost:7902" ,configuration=Configuration2.class)
public interface FeignClientTwo {

	@RequestMapping(value="/eureka/apps/{serviceName}")
	public String findServerInfoForServerName(@PathVariable("serviceName")String serviceName);
}
