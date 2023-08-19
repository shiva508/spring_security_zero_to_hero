package com.pool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/r&d/")
public class ResearchAndDevelopmentController {
	@GetMapping("/")
public String rd() {
	return "rd";
}
}
