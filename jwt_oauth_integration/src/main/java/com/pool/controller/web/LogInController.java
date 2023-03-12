package com.security.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogInController {
	@GetMapping("/login")
	public String loginpage() {
		return "login";
	}
}
