package com.learning.microservices.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.microservices.limitsservice.configuration.Configuration;
import com.learning.microservices.limitsservice.model.Limits;

@RestController
public class LimitsController {

	@Autowired
	private Configuration config;
	
	@Value("${my.name}")
	private String name;

	@GetMapping("/limits")
	public Limits getLimts() {
		return new Limits(config.getMinimum(), config.getMaximum());
//		return new Limits(1, 1000);
	}

	@GetMapping("/limits/name")
	public String getFromValue() {
		return name;
	}

}
