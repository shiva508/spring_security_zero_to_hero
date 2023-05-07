package com.pool.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.pool.jwt.filters.JWTFilter;
import com.pool.service.registration.CustomUserDetailsService;

//@Configuration
//@EnableWebSecurity
public class AppSpringSecirityConfig {
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	@Autowired
	private JWTFilter jWTFilter;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		    http.authorizeHttpRequests()
				.requestMatchers("/registraion/**").permitAll()
				.requestMatchers("/employee/**").hasRole("ADMIN")
				.anyRequest().authenticated()
				.and()
				.formLogin().loginPage("/login").defaultSuccessUrl("/dashboard",true).permitAll(true)
				.and()
				.logout().logoutSuccessUrl("/login?logout").permitAll()
				.and()
				.exceptionHandling().accessDeniedPage("/403")
				.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.addFilterBefore(jWTFilter,UsernamePasswordAuthenticationFilter.class);

		http.csrf().disable();
		http.headers().cacheControl();
		return http.build();
	}
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() throws Exception {
		return web-> web.ignoring().requestMatchers("/components/**");
	}
	@Bean
	public UserDetailsService configure(AuthenticationManagerBuilder auth) throws Exception {
		return customUserDetailsService;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
