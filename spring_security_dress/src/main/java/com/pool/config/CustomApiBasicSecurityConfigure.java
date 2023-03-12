package com.pool.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.security.password.PasswordEncoderUtil;
import com.security.utils.USER_PERMISIONS;
import com.security.utils.USER_ROLES;

//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity( prePostEnabled = true)
public class CustomApiBasicSecurityConfigure extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private PasswordEncoderUtil passwordEncoderUtil;
	
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
		//.csrf()
		//.disable()
		.authorizeRequests()
		.antMatchers("/", "index", "/css/*", "/js/*")
		.permitAll()
		.antMatchers("/api/**").hasRole(USER_ROLES.USER.name())
		.antMatchers(HttpMethod.POST,"/purchase/**").hasAuthority(USER_PERMISIONS.ADMIN_WRITE.name())
		.antMatchers(HttpMethod.DELETE,"/purchase/**").hasAuthority(USER_PERMISIONS.ADMIN_WRITE.name()) 
		.antMatchers(HttpMethod.PUT,"/purchase/**").hasAuthority(USER_PERMISIONS.ADMIN_WRITE.name())
		.antMatchers(HttpMethod.GET,"/purchase/**").hasAnyRole(USER_ROLES.MANAGER.name(),USER_ROLES.ADMIN.name())
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
	}

	@Override
	@Bean
	protected UserDetailsService userDetailsService() {
		UserDetails shiva_user=User.builder()
				.username("shiva")
				.password(passwordEncoder().encode("shiva"))
				//.roles(USER_ROLES.USER.name())
				.authorities(USER_ROLES.USER.getGrantedAuthorities())
				.build();
		
		UserDetails dasari_admin=User.builder()
				.username("dasari")
				.password(passwordEncoder().encode("dasari"))
				//.roles(USER_ROLES.ADMIN.name())
				.authorities(USER_ROLES.ADMIN.getGrantedAuthorities())
				.build();
		
		UserDetails manager_manager=User.builder()
				.username("manager")
				.password(passwordEncoder().encode("manager"))
				//.roles(USER_ROLES.MANAGER.name())
				.authorities(USER_ROLES.MANAGER.getGrantedAuthorities())
				.build();
		return new InMemoryUserDetailsManager(shiva_user,dasari_admin,manager_manager);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}
	
}
