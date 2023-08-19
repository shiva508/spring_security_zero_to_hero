package com.pool.controller;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
/* @RequestMapping("/employe/") */
public class LoginController {
	@GetMapping("/")
	public String welcome() {
		return "welcome";
	}
	@GetMapping("/loginpage")
	public String loginPage() {
		return  "loginPage";
	}
	@GetMapping("/403")
	public String accessDenied() {
		return "accessDenied";
	}
}
