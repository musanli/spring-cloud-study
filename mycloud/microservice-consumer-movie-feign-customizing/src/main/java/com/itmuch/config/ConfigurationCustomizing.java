package com.itmuch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Contract;
import feign.Logger;

@Configuration
public class ConfigurationCustomizing {

	@Bean
	public Contract feignContract() {
		return new feign.Contract.Default();
	}
	
	@Bean
	Logger.Level feignLoggerLevel(){
		System.out.println("feignLoggerLevel（）");
		return Logger.Level.FULL;
	}
}
