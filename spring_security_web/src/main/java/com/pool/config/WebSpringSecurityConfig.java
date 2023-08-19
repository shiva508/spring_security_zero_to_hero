package com.pool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSpringSecurityConfig{
	@Bean
	public UserDetailsService userDetailsService(){
		UserBuilder users=User.withDefaultPasswordEncoder();;
		return new InMemoryUserDetailsManager(
				users.username("shiva").password("shiva").roles("ADMIN","EMPLOYEE").build(),
				users.username("satish").password("satish").roles("CEO","MANAGER","EMPLOYEE").build(),
				users.username("ravi").password("ravi").roles("RND","MANAGER","EMPLOYEE").build());
	}
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
				.authorizeHttpRequests(amrmr -> {
					amrmr.requestMatchers("/").hasRole("EMPLOYEE");
					amrmr.requestMatchers("/admin/**").hasRole("ADMIN");
					amrmr.requestMatchers("/ceo/**").hasRole("CEO");
					amrmr.requestMatchers("/r&d/").hasAnyRole("RND","MANAGER");
				})
				.formLogin(httpSecurityFormLoginConfigurer -> httpSecurityFormLoginConfigurer.loginPage("/loginpage").loginProcessingUrl("login").permitAll())
				.logout(LogoutConfigurer::permitAll)
				.exceptionHandling(httpSecurityExceptionHandlingConfigurer ->httpSecurityExceptionHandlingConfigurer.accessDeniedPage("/403"))
				.build();
	}
	
}
