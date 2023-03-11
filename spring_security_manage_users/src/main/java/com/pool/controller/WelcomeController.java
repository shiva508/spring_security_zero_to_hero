package com.pool.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@GetMapping("/home")
	public String welcome() {
		return "Wlcome";
	}
}
