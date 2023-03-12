package com.pool.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.pool.service.UserService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(jsr250Enabled = true, securedEnabled = true, prePostEnabled = true)
public class EpoolWebsecurity  {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private UserService userService;
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private EpoolEnvConfiguration envConfiguration;


	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeHttpRequests().requestMatchers("/userprofile/**","/actuator/**").permitAll()
		.anyRequest()
		.authenticated().and()
				.addFilter(getAuthenticationFilter()).formLogin();
		http.headers().frameOptions().disable();
		return http.build();
	}

	private EpoolAuthenticationFilter getAuthenticationFilter() throws Exception {
		//EpoolAuthenticationFilter authenticationFilter = new EpoolAuthenticationFilter(userService,environment,authenticationManager());
		EpoolAuthenticationFilter authenticationFilter = new EpoolAuthenticationFilter(userService,environment,null);
		authenticationFilter.setFilterProcessesUrl(environment.getProperty("login.url.path"));
		//authenticationFilter.setFilterProcessesUrl(environment.getProperty("login.url.path"));
		//authenticationFilter.setAuthenticationManager(authenticationManager());
		return authenticationFilter;
	}
/*
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
	}*/
}
