package com.pool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.pool.service.UserProfileService;

@Configuration
public class StudentpoolSecurityUserDetailsServiceConfig {
	@Bean
	public UserDetailsService userDetailsServicee() {
		return new UserProfileService();
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
