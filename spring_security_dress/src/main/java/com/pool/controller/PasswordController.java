package com.pool.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.password.CustomSecurityContextHolder;
import com.security.password.PasswordEncoderInfo;

@RestController
@RequestMapping("/password")
public class PasswordController {
	@Autowired
	private PasswordEncoderInfo passwordEncoderInfo;

	@Autowired
	private CustomSecurityContextHolder customSecurityContextHolder;

	@GetMapping("/encoder")
	public String passwordEncoder() {
		return passwordEncoderInfo.passwordGenerator();
	}

	@GetMapping("/customEncoder/{encoderName}")
	public String customPasswordEncoder(@PathVariable("encoderName") String encoderName) {
		return passwordEncoderInfo.customPasswordEncoder(encoderName);
	}

	@GetMapping("/user")
	public User securityUser() {
		return passwordEncoderInfo.userSecurity();
	}

	@GetMapping("/userDetails")
	public UserDetails securityUserDetails() {
		return passwordEncoderInfo.userDetailsSecurity();
	}

	@GetMapping("/securityDetails")
	public ResponseEntity<Map<Object, Object> > securityDetailsObject(){
		return new ResponseEntity<Map<Object,Object>>(customSecurityContextHolder.customSecurityContextHolder(), HttpStatus.OK);
	}
}
