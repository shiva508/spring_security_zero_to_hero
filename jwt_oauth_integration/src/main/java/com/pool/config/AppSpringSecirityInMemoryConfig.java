package com.pool.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

public class AppSpringSecirityInMemoryConfig  {
	@Autowired
	private UserDetailsService userDetailsService;
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
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

		http.authorizeHttpRequests(authriz -> {
			authriz.requestMatchers("/registraion/**").permitAll();
			authriz.requestMatchers("/employee/**").hasRole("ADMIN");
			authriz.anyRequest().authenticated();
		}).formLogin(formlog->{
			formlog.loginPage("/login").defaultSuccessUrl("/dashboard",true).permitAll(true);
		}).logout(logout->{
			logout.logoutSuccessUrl("/login?logout").permitAll();
		}).exceptionHandling(exceptionHandling -> {
			exceptionHandling.accessDeniedPage("/403");
		});
		/*http.authorizeRequests()
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
		.accessDeniedPage("/403");*///allow all as it will be accessed when user is not logged in anymore
		return http.build();
	}

	/*@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}*/

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer()  {
		return web-> web.ignoring().requestMatchers("/components/**");
	}
	@Bean
	public UserDetailsService userDetailsService(){
		UserDetails userDetailsOne= User.withUsername("shiva").password(passwordEncoder().encode("shiva")).roles("USER").build();
		UserDetails userDetailsTwo= User.withUsername("shivad").password(passwordEncoder().encode("shivad")).roles("ADMIN").build();
		return new InMemoryUserDetailsManager(userDetailsOne,userDetailsTwo);
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
