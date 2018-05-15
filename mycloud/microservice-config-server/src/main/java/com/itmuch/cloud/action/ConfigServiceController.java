package com.itmuch.cloud.action;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigServiceController {

	@Value("${abc.profiles}")
	String abcprofiles;

	@GetMapping(name="getProfiles1")
	public String getProfiles1() {
		return abcprofiles;
	}
}
