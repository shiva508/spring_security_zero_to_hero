package com.pool.password;

import java.util.HashMap;

import java.util.Map;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoderInfo {
	public String passwordGenerator() {
		PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		String encodedPassword=passwordEncoder.encode("Shiva");
		return encodedPassword;
	}
	
	public String customPasswordEncoder(String encoderName) {
		Map encoders=new HashMap<>();
		encoders.put("bcrypt", new BCryptPasswordEncoder());
		encoders.put("noop", NoOpPasswordEncoder.getInstance());
		encoders.put("pbkdf2", new Pbkdf2PasswordEncoder());
		encoders.put("scrypt", new SCryptPasswordEncoder());
		encoders.put("sha256", new StandardPasswordEncoder());
		PasswordEncoder passwordEncoder=new DelegatingPasswordEncoder(encoderName, encoders);
		return passwordEncoder.encode("Shiva");
	}
	public User userSecurity() {
		User user = (User) User.withDefaultPasswordEncoder()
				  .username("user")
				  .password("password")
				  .roles("user")
				  .build();
		return user;
	}
	
	public UserDetails userDetailsSecurity() {
		UserDetails userDetails=User.withDefaultPasswordEncoder()
				.username("Shiva")
				.password("Shiva")
				.roles("Admin","USER")
				.build();
		return userDetails;
		
	}
}
