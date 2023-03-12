package com.pool.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.pool.config.filter.StudentpoolAuthenticationFilter;
import com.pool.config.handler.StudentpoolAuthenticationFailureHadler;

@Configuration
public class StudentpoolSecurityConfig {

	private final StudentpoolAuthenticationFilter authenticationFilter;
	
	private final StudentpoolAuthenticationFailureHadler authenticationFailureHadler;

	public StudentpoolSecurityConfig(StudentpoolAuthenticationFilter authenticationFilter,
			StudentpoolAuthenticationFailureHadler authenticationFailureHadler) {
		this.authenticationFilter = authenticationFilter;
		this.authenticationFailureHadler = authenticationFailureHadler;
	}



	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.addFilterAt(authenticationFilter, UsernamePasswordAuthenticationFilter.class)
				.authorizeHttpRequests()
				.anyRequest()
				.authenticated()
				/*
				 * .and().exceptionHandling() .accessDeniedHandler(authenticationFailureHadler)
				 */
				.and().build();
	}
}
