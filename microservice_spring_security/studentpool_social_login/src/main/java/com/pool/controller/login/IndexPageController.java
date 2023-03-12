package com.pool.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexPageController {
	@GetMapping("/")
	public String displayIndexPage() {
		return "index";
	}
}
