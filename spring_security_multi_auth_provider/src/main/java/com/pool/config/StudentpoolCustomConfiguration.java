package com.pool.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.pool.config.filter.CustomUsernamePasswordAuthenticationFilter;
import com.pool.config.filter.TokenAuthenticationFilter;
import com.pool.config.provider.OtpAuthenicationProvider;
import com.pool.config.provider.TokenAuthProvider;
import com.pool.config.provider.UserNamepasswordAuthenicationProvider;

@Configuration
//@EnableAsync
public class StudentpoolCustomConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private OtpAuthenicationProvider otpAuthenicationProvider;

	@Autowired
	private UserNamepasswordAuthenicationProvider userNamepasswordAuthenicationProvider;

	@Autowired
	private TokenAuthProvider tokenAuthProvider;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) {
		auth.authenticationProvider(otpAuthenicationProvider)
				.authenticationProvider(userNamepasswordAuthenicationProvider)
				.authenticationProvider(tokenAuthProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.addFilterAt(usernamePasswordAuthenticationFilter(), BasicAuthenticationFilter.class)
				.addFilterAfter(tokenAuthenticationFilter(), BasicAuthenticationFilter.class);
		/*
		 * http.authorizeRequests() .anyRequest() .permitAll();
		 */
	}

	@Bean
	public TokenAuthenticationFilter tokenAuthenticationFilter() {
		return new TokenAuthenticationFilter();
	}

	@Bean
	public CustomUsernamePasswordAuthenticationFilter usernamePasswordAuthenticationFilter() {
		return new CustomUsernamePasswordAuthenticationFilter();
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	/*
	@Bean
	public InitializingBean initializingBean() {
		return ()->{
			SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
		};
	}
	*/
}
