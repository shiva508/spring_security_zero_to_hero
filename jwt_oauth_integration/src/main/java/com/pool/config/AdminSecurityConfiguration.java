package com.pool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.DigestAuthenticationFilter;

/*@Configuration
@Order(1)*/
public class AdminSecurityConfiguration  {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
				.requestMatchers("/employee/**").hasAnyRole("ADMIN")
				.and()
				.addFilter(authenticationFilter()).exceptionHandling()
				.authenticationEntryPoint(getDigetstEntryPoint());
		 return http.build();
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
	@Bean
	public UserDetailsService userDetailsServiceBean(){
		UserDetails userDetailsOne= User.withUsername("shiva").password(passwordEncoder().encode("shiva")).roles("USER").build();
		UserDetails userDetailsTwo= User.withUsername("shivad").password(passwordEncoder().encode("shivad")).roles("ADMIN").build();
		return new InMemoryUserDetailsManager(userDetailsOne,userDetailsTwo) ;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
