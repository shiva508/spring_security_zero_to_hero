package com.pool.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import com.pool.config.util.RoleExtractor;
import com.pool.constants.OAuthConstants;
import com.pool.handler.exception.OauthAccessDeniedHandler;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(jsr250Enabled = true, securedEnabled = true, prePostEnabled = true)
public class StudentPoolFriendsSecurityConfig{

	@Autowired
	private OauthAccessDeniedHandler oauthAccessDeniedHandler;
	
	@Bean
	public JwtAuthenticationConverter jwtAuthenticationConverter() {
		JwtAuthenticationConverter authenticationConverter = new JwtAuthenticationConverter();
		authenticationConverter.setJwtGrantedAuthoritiesConverter(new RoleExtractor());
		return authenticationConverter;
	}

	@Bean
	protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
		
		 http
		.authorizeHttpRequests()
		.requestMatchers(OAuthConstants.OAUTH_TOKEN_PUBLIC_URLS).permitAll()
		.requestMatchers(OAuthConstants.APP_CONTEXT_PATH+OAuthConstants.URL_FRIENDS).hasRole(OAuthConstants.ROLE_STUDENT)
		.anyRequest()
		.authenticated()
		.and()
		.exceptionHandling()
		.accessDeniedHandler(oauthAccessDeniedHandler)
		.and()
		.oauth2ResourceServer().jwt().jwtAuthenticationConverter(jwtAuthenticationConverter());
		return http.build();
	}
}
