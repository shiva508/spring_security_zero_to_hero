package com.pool.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.pool.service.registration.CustomUserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class AppSpringSecirityDbConfig  {
	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(authriz->{
			authriz.requestMatchers("/registraion/**").permitAll();
			authriz.requestMatchers("/employee/**").hasRole("ADMIN");
			authriz.anyRequest().authenticated();
		}).formLogin(login->{
			login.loginPage("/login").defaultSuccessUrl("/dashboard",true).permitAll(true);
		}).logout(logout->{
			logout.logoutSuccessUrl("/login?logout").permitAll();
		}).exceptionHandling(eha->{
			eha.accessDeniedPage("/403");
		});
		return http.build();
	}

	@Bean
	public WebSecurityCustomizer configure() {
		return web->web.ignoring().requestMatchers("/components/**");
	}

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService)
		.passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
