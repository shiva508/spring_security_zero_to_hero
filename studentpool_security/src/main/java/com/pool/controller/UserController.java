package com.pool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pool.model.UserModel;

@RestController
public class UserController {

	@Autowired
	private JdbcUserDetailsManager jdbcUserDetailsManager;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/hi")
	public ResponseEntity<String> hello() {
		return new ResponseEntity<>("Hi!!!!!!", HttpStatus.OK);
	}

	@PostMapping("/adduser")
	public ResponseEntity<String> addUser(@RequestBody UserModel userModel) {
		userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
		jdbcUserDetailsManager.createUser(userModel);
		return new ResponseEntity<>("New user created", HttpStatus.CREATED);
	}
}
