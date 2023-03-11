package com.pool.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.pool.config.filter.ApiKeyFilter;
import com.pool.config.filter.CustomAuthFailureHandler;
import com.pool.config.filter.JwtAuthenticationEntryPoint;

@Configuration
public class StudentpoolSecurityConfig {

	@Value("${the.secret}")
	private String scecret;

	@Autowired
	private CustomAuthFailureHandler customAuthFailureHandler;

	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
				.httpBasic()
				.and()
				.addFilterBefore(new ApiKeyFilter(scecret), BasicAuthenticationFilter.class)
				.authorizeRequests(auth -> auth.anyRequest().authenticated())
				.exceptionHandling().accessDeniedHandler(customAuthFailureHandler)
				.authenticationEntryPoint(jwtAuthenticationEntryPoint)
				.and()
				.build();
	}

}
