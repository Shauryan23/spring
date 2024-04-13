package com.spring.springEMS.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {

	@GetMapping("/test")
	public String testController() {
		System.out.println("Test Controller Called!");
		return "Test Page";
	}
}
