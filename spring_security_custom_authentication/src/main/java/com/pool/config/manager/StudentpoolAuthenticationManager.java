package com.pool.config.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.pool.config.authentication.StudentpoolAuthentication;
import com.pool.config.provider.StudentpoolAuthenticationProvider;

@Component
public class StudentpoolAuthenticationManager implements AuthenticationManager {

	private StudentpoolAuthenticationProvider studentpoolAuthenticationProvider;

	@Autowired
	public StudentpoolAuthenticationManager(StudentpoolAuthenticationProvider studentpoolAuthenticationProvider) {
		this.studentpoolAuthenticationProvider = studentpoolAuthenticationProvider;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		if (studentpoolAuthenticationProvider.supports(StudentpoolAuthentication.class)) {
			return studentpoolAuthenticationProvider.authenticate(authentication);
		} else {
			throw new BadCredentialsException("Bad too bad");
		}
	}
}
