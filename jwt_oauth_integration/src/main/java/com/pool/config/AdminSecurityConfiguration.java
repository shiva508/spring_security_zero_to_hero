package com.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.UserDetailsServiceFactoryBean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.DigestAuthenticationFilter;

/*@Configuration
@Order(1)*/
public class AdminSecurityConfiguration extends WebSecurityConfigurerAdapter {
	 @Override
	protected void configure(HttpSecurity http) throws Exception {
		 http.antMatcher("/employee/**")
		 .addFilter(authenticationFilter()).exceptionHandling()
		 .authenticationEntryPoint( getDigetstEntryPoint())
		 .and().authorizeRequests()
		 .antMatchers("/employee/**").hasRole("ADMIN");
	}
	public DigestAuthenticationFilter authenticationFilter() throws Exception {
		DigestAuthenticationFilter authenticationFilter=new DigestAuthenticationFilter();
		authenticationFilter.setUserDetailsService(userDetailsServiceBean());
		authenticationFilter.setAuthenticationEntryPoint(getDigetstEntryPoint());
		authenticationFilter.setPasswordAlreadyEncoded(true);
		authenticationFilter.setCreateAuthenticatedToken(true);
		return authenticationFilter;
	}
	public DigestAuthenticationEntryPoint getDigetstEntryPoint() {
		DigestAuthenticationEntryPoint entryPoint = new DigestAuthenticationEntryPoint();
		entryPoint.setRealmName("admin-digest-realm");
		entryPoint.setKey("fkksss_+");
		return entryPoint;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("Shiva").password("Shiva").roles("ADMIN").and().withUser("Shiva1")
				.password("Shiva1").roles("user");
	}

	@Override
	@Bean
	public UserDetailsService userDetailsServiceBean() throws Exception {
		return super.userDetailsServiceBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
}
