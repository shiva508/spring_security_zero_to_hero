package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ceo/")
public class CeoController {
	@GetMapping("/")
public String ceoPAge() {
	return "ceoPage";
}
}
