package com.pool.oauth.config;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DefaultAuthenticationEventPublisher;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.security.oauth.constants.OAuthConstants;
import com.security.oauth.entrypoint.OauthJwtAthenticationEntryPoint;
import com.security.oauth.filter.OauthJwtAuthenticationFilter;
import com.security.oauth.handler.OauthAccessDeniedHandler;
import com.security.oauth.service.CustomUserModelService;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class OauthSpringSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private CustomUserModelService customUserModelService;
	@Autowired
	private OauthJwtAuthenticationFilter oauthJwtAuthenticationFilter;
	@Autowired
	private OauthJwtAthenticationEntryPoint oauthJwtAthenticationEntryPoint;
	@Autowired
	private OauthAccessDeniedHandler oauthAccessDeniedHandler;
	/*
	 * @Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;
	 */
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.authenticationEventPublisher(authenticationEventPublisher())
			.userDetailsService(customUserModelService)
			.passwordEncoder(bCryptPasswordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		   web.ignoring().antMatchers("/v2/api-docs",
                   "/configuration/ui",
                   "/swagger-resources/**",
                   "/swagger-ui.html",
                   "/webjars/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.cors()
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.authorizeRequests()
		.antMatchers(OAuthConstants.OAUTH_TOKEN_PUBLIC_URLS).permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.exceptionHandling().accessDeniedHandler(oauthAccessDeniedHandler)
		.authenticationEntryPoint(oauthJwtAthenticationEntryPoint)
		.and()
		.addFilterBefore(oauthJwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	@Bean
    public DefaultAuthenticationEventPublisher authenticationEventPublisher() {
        return new DefaultAuthenticationEventPublisher();
    }
}
