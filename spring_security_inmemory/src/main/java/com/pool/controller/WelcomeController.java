package com.pool.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@GetMapping("/welcome")
	public ResponseEntity<String> welcome(){
		return new ResponseEntity<>("HI", HttpStatus.OK);
	}
}
