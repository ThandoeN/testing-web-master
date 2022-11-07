package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	
	@Autowired
	private GreetingService service;
	
	@GetMapping("/greeting")
	public String greeting() {
		return service.greet();
	}
}
