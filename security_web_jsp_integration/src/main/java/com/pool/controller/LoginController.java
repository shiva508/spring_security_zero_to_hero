package com.pool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	@GetMapping("/loginpage")
public String loginPage() {
	return "login";
}
	@GetMapping("/403")
	public String accessDenied() {
		return "accessDenied";
	}
}
