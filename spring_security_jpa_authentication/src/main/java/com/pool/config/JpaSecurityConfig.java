package com.pool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import com.pool.config.handler.CustomAccessDeniedHandler;
import com.pool.config.handler.CustomAuthenticationFailureHandler;
import com.pool.service.UserProfileService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class JpaSecurityConfig {
	
	private final UserProfileService userProfileService;
	
	private final CustomAuthenticationFailureHandler failureHandler;
	
	private final CustomAccessDeniedHandler deniedHandler;
	
	
	public JpaSecurityConfig(UserProfileService userProfileService, 
							 CustomAuthenticationFailureHandler failureHandler,
							 CustomAccessDeniedHandler deniedHandler) {
		this.userProfileService = userProfileService;
		this.failureHandler = failureHandler;
		this.deniedHandler = deniedHandler;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
				.csrf(csrf->csrf.disable())
				.authorizeRequests(auth->auth
				.antMatchers("/api/posts/**").permitAll()
				.anyRequest()
				.authenticated())
				.formLogin()
				//.failureHandler(failureHandler)
				.and()
				.userDetailsService(userProfileService)
				.httpBasic(Customizer.withDefaults())
				.exceptionHandling()
				.accessDeniedHandler(deniedHandler)
				.and()
				.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
