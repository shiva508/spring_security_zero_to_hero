package com.pool.config.DBSecurityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.pool.serviceImpl.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class DBSpringScuryConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Bean
	public DaoAuthenticationProvider authProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(customUserDetailsService);
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authProvider());
	}
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/component/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.headers()
        .frameOptions().sameOrigin()
        .and().authorizeRequests()
				.antMatchers("/**").hasRole("EMPLOYEE")
				.antMatchers("/upload/**").hasRole("EMPLOYEE").
				antMatchers("/admin/**").hasRole("ADMIN")
				.antMatchers("/ceo/**").hasRole("CEO")
				.antMatchers("/r&d/").hasAnyRole("RND", "MANAGER")
				.antMatchers("/h2-console/**").permitAll()
				.anyRequest().authenticated().
				and().formLogin().loginPage("/loginpage").failureUrl("/loginpage?error")
				.loginProcessingUrl("/login").permitAll()
				.and().logout().logoutSuccessUrl("/loginpage?logout").permitAll().
				and().exceptionHandling().accessDeniedPage("/403");
		/*http.csrf().disable();
		http.headers().frameOptions().disable();*/
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new PasswordEncoder() {
			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				return true;
			}
			@Override
			public String encode(CharSequence rawPassword) {
				return rawPassword.toString();
			}
		};
	}
}
