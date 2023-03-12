package com.pool.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.pool.config.filter.CustomAuthenticationFilter;
import com.pool.config.provider.CustomAuthenticationWithFilterProvider;

//@Configuration
public class StudentpoolSecurityCustomFilterConfig{

	@Autowired
	private CustomAuthenticationFilter customAuthenticationFilter;

	@Autowired
	private CustomAuthenticationWithFilterProvider authenticationWithFilterProvider;

	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationWithFilterProvider);
	}
	
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return null;
	}

	
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
