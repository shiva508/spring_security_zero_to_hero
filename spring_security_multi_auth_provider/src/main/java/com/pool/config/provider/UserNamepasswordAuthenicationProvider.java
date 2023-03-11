package com.pool.config.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.pool.config.authentication.UsernamePasswordAuthentication;
import com.pool.util.StudentpoolConstents;

@Component
public class UserNamepasswordAuthenicationProvider implements AuthenticationProvider {

	private PasswordEncoder passwordEncoder;

	private UserDetailsService userDetailsService;

	@Autowired
	public UserNamepasswordAuthenicationProvider(PasswordEncoder passwordEncoder,
			UserDetailsService userDetailsService) {
		this.passwordEncoder = passwordEncoder;
		this.userDetailsService = userDetailsService;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = (String) authentication.getCredentials();
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
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
