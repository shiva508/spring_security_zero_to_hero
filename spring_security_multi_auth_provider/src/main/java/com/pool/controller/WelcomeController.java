package com.pool.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	@GetMapping("/welcome")
	public ResponseEntity<String> hello(Authentication authentication) {
		return new ResponseEntity<>("Hi!!!!!! "+authentication.getName(), HttpStatus.OK);
	}
	
	@GetMapping("/welcomeshiav")
	//@Async
	public ResponseEntity<String> helloJone() {
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		return new ResponseEntity<>("Hi!!!!!! "+authentication.getName(), HttpStatus.OK);
	}
}
