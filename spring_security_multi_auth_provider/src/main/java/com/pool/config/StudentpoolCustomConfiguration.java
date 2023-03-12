package com.pool.config;

import com.pool.config.provider.CustomUNPAuthenticationProvider;
import com.pool.config.provider.CustomUserNamePasswordAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.pool.config.filter.CustomUsernamePasswordAuthenticationFilter;
import com.pool.config.filter.TokenAuthenticationFilter;
import com.pool.config.provider.OtpAuthenicationProvider;
import com.pool.config.provider.TokenAuthProvider;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class StudentpoolCustomConfiguration  {

	@Autowired
	private OtpAuthenicationProvider otpAuthenicationProvider;

	/*@Autowired
	private CustomUserNamePasswordAuthenticationProvider customUserNamePasswordAuthenicationProvider;
*/
	@Autowired
	private TokenAuthProvider tokenAuthProvider;

	@Autowired
	private CustomUNPAuthenticationProvider customUNPAuthenticationProvider;
	/*@Autowired
	private CustomUsernamePasswordAuthenticationFilter customUsernamePasswordAuthenticationFilter;

	@Autowired
	private TokenAuthenticationFilter tokenAuthenticationFilter;*/
	@Bean("noOpPasswordEncoder")
	public PasswordEncoder noOpPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http, AuthenticationManager authenticationManager) throws Exception {
		return http
				.authenticationManager(authenticationManager)
				.authenticationProvider(otpAuthenicationProvider)
				.authenticationProvider(customUNPAuthenticationProvider)
				.authenticationProvider(tokenAuthProvider)
				.addFilterAt(new CustomUsernamePasswordAuthenticationFilter(),BasicAuthenticationFilter.class)
				//.addFilterAfter(new TokenAuthenticationFilter(authenticationManager),BasicAuthenticationFilter.class)
				/*.addFilterAt(customUsernamePasswordAuthenticationFilter,BasicAuthenticationFilter.class)
				.addFilterAfter(tokenAuthenticationFilter,BasicAuthenticationFilter.class)*/
				.build();
	}

	/*@Override
	protected void configure(AuthenticationManagerBuilder auth) {
		auth.authenticationProvider(otpAuthenicationProvider)
				.authenticationProvider(userNamepasswordAuthenicationProvider)
				.authenticationProvider(tokenAuthProvider);
	}*/

	/*@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.addFilterAt(usernamePasswordAuthenticationFilter(), BasicAuthenticationFilter.class)
				.addFilterAfter(tokenAuthenticationFilter(), BasicAuthenticationFilter.class);
	}*/

	/*@Bean
	public TokenAuthenticationFilter tokenAuthenticationFilter() {
		return new TokenAuthenticationFilter();
	}

	@Bean
	public CustomUsernamePasswordAuthenticationFilter usernamePasswordAuthenticationFilter() {
		return new CustomUsernamePasswordAuthenticationFilter();
	}*/

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		return authenticationManagerBuilder.getObject();
	}
	/*@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}*/

}
