package com.pool.config.provider;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.pool.config.authentication.UsernamePasswordAuthentication;
import com.pool.util.StudentpoolConstents;

import java.util.Collection;

//@Component
public class CustomUserNamePasswordAuthenticationProvider implements AuthenticationProvider {

	private final PasswordEncoder passwordEncoder;

	//private final UserDetailsService jpaUserDetailsService;


	public CustomUserNamePasswordAuthenticationProvider(PasswordEncoder passwordEncoder
													   //@Qualifier("jpaUserDetailsService") UserDetailsService jpaUserDetailsService
	) {
		this.passwordEncoder = passwordEncoder;
		//this.jpaUserDetailsService = jpaUserDetailsService;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = (String) authentication.getCredentials();
		//UserDetails userDetails = jpaUserDetailsService.loadUserByUsername(username);
		UserDetails userDetails=new UserDetails() {
			@Override
			public Collection<? extends GrantedAuthority> getAuthorities() {
				return null;
			}

			@Override
			public String getPassword() {
				return null;
			}

			@Override
			public String getUsername() {
				return "shiva";
			}

			@Override
			public boolean isAccountNonExpired() {
				return false;
			}

			@Override
			public boolean isAccountNonLocked() {
				return false;
			}

			@Override
			public boolean isCredentialsNonExpired() {
				return false;
			}

			@Override
			public boolean isEnabled() {
				return false;
			}
		};
		if (passwordEncoder.matches(password, userDetails.getPassword())) {
			return new UsernamePasswordAuthentication(username, password, userDetails.getAuthorities());
		} else {
			throw new BadCredentialsException(StudentpoolConstents.BAD_CREDENTIALS);
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthentication.class.equals(authentication);
	}

}
