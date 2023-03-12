package com.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AppSpringSecirityInMemoryConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*http.authorizeRequests().antMatchers("/registration/**")
		.permitAll().anyRequest()
		.authenticated()
		.and().formLogin()
		.loginPage("/login")
		.loginProcessingUrl("/authenicatuser")
		.defaultSuccessUrl("/dashboard",true)
		.defaultSuccessUrl("/login?error=true")
		.permitAll()
		.and()
		.logout()
		.permitAll()
		.and()
		.exceptionHandling()
		.accessDeniedPage("/403");*/
	/*	http.csrf().disable();*/
		http.authorizeRequests()
		.antMatchers("/registraion/**")
		.permitAll()
		.antMatchers("/employee/**")
		.hasRole("ADMIN")
        .anyRequest()//allow all urls
        .authenticated()//all URLs are allowed by any authenticated user, no role restrictions.
        .and()
        .formLogin()//enable form based authentication
        .loginPage("/login")
        .defaultSuccessUrl("/dashboard",true)//use a custom login URI
        .permitAll(true)//login URI can be accessed by anyone
        .and()
        .logout()//default logout handling
        .logoutSuccessUrl("/login?logout")//our new logout success url, we are not replacing other defaults.
        .permitAll().and()
		.exceptionHandling()
		.accessDeniedPage("/403");//allow all as it will be accessed when user is not logged in anymore
	}

	/*@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}*/

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/components/**");
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("Shiva")
		.password("Shiva").roles("ADMIN")
		.and().withUser("Shiva1")
		.password("Shiva1").
		roles("user");
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
