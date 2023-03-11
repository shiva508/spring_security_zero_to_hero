package com.pool.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserBasicController {
	@GetMapping("/hi")
	public ResponseEntity<String> hello() {
		return new ResponseEntity<>("Hi!!!!!!", HttpStatus.OK);
	}
}
