package com.security.controller.web;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
	@GetMapping("/dashboard")
	public String welcome() {
		return "Dashboard";
	}
	@GetMapping("/403")
	public String authFail() {
		return "403";
	}
}
