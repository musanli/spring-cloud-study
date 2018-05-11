package com.itmuch.config;

import org.springframework.context.annotation.Bean;

import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;

public class Configuration2 {

	@Bean
	public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
		return new BasicAuthRequestInterceptor("user", "pw");
	}

	@Bean
	Logger.Level feignLoggerLevel() {
		System.out.println("feignLoggerLevel（）");
		return Logger.Level.FULL;
	}
}
