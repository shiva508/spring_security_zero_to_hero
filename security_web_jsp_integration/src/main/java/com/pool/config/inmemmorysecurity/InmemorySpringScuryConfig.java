package com.pool.config.inmemmorysecurity;/*package com.infinity.config.inmemmorysecurity;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class InmemorySpringScuryConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		UserBuilder users=User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication().withUser(users.username("shiva").password("shiva").roles("ADMIN","EMPLOYEE"))
		.withUser(users.username("satish").password("satish").roles("CEO","MANAGER","EMPLOYEE"))
		.withUser(users.username("ravi").password("ravi").roles("RND","MANAGER","EMPLOYEE"));
	}
		
		@Override
			protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests()
					.anyRequest().authenticated() //used to authenticate only on user 
			.antMatchers("/").hasRole("EMPLOYEE")
			.antMatchers("/admin/**").hasRole("ADMIN")
			.antMatchers("/ceo/**").hasRole("CEO")
			.antMatchers("/r&d/").hasAnyRole("RND","MANAGER")
			.and()
			.formLogin()
			.loginPage("/loginpage")
			.loginProcessingUrl("/login")
			 .failureUrl("/loginpage")
			.permitAll()
			.and()
			.logout()
			.permitAll()
			.and()
			.exceptionHandling()
			.accessDeniedPage("/403");
			}
}
*/