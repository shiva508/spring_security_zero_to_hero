package com.pool.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.pool.config.filter.CustomAuthenticationFilter;
import com.pool.config.filter.CustomAuthenticationOncePerRequestFilter;
import com.pool.config.provider.CustomAuthenticationWithFilterProvider;

@Configuration
public class StudentpoolSecurityCustAuthFilterConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomAuthenticationWithFilterProvider customAuthenticationWithFilterProvider;
	
	@Bean
	public CustomAuthenticationOncePerRequestFilter authenticationOncePerRequestFilter() {
		CustomAuthenticationOncePerRequestFilter perRequestFilter=null;
		try {
			perRequestFilter = new CustomAuthenticationOncePerRequestFilter(authenticationManagerBean());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return perRequestFilter;
	}
	
	@Bean
	public CustomAuthenticationFilter customAuthenticationFilter() {
		CustomAuthenticationFilter customAuthenticationFilter = null;
		try {
			customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customAuthenticationFilter;
	}

	

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(customAuthenticationWithFilterProvider);
	}

	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.addFilterAt(customAuthenticationFilter(), BasicAuthenticationFilter.class);

	        http.authorizeRequests()
	                .anyRequest()
	                .permitAll();
	    }
}
