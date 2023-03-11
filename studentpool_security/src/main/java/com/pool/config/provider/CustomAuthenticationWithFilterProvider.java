package com.pool.config.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.pool.config.authentication.CustomAuthentication;

//@Component
public class CustomAuthenticationWithFilterProvider implements AuthenticationProvider {

	@Value("${key}")
	private String value;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String requestNey = authentication.getName();

		if (null == requestNey) {
			throw new BadCredentialsException("Please provide Valid credentials");
		} else {
			if (requestNey.equals(value)) {
				CustomAuthentication authenticationToken = new CustomAuthentication(null, null, null);
				return authenticationToken;
			} else {
				throw new BadCredentialsException("Please provide Valid credentials");
			}
		}
	}

	@Override
	public boolean supports(Class<?> authenticationType) {
		return CustomAuthentication.class.equals(authenticationType);
	}

}
