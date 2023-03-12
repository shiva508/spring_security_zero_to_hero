package com.pool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class StudentPoolSecurityConfiguration {

	@Bean
	public SecurityFilterChain configurationSecurityFilterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(authorizeRequests -> authorizeRequests.anyRequest().authenticated())
				.formLogin(Customizer.withDefaults());

		return http.build();
	}

	@Bean
	public UserDetailsService users() {

		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

		UserDetails user = User.withUsername("dasari508").password(encoder.encode("dasari508")).roles("USER").build();

		return new InMemoryUserDetailsManager(user);

	}
}
