package com.pool.config.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.pool.config.authentication.TokenAuthentication;
import com.pool.config.manager.GenericComponent;
import com.pool.config.manager.TokenManager;
import com.pool.util.StudentpoolConstents;

import lombok.extern.slf4j.Slf4j;


public class TokenAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private AuthenticationManager authenticationManager;


	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String token = request.getHeader(StudentpoolConstents.AUTHORIZATION);

		//boolean tokenManagerThread = GenericComponent.threadLocal.get().contains(token);
		Authentication tokenAuthentication = new TokenAuthentication(token, null);
		Authentication authenticated = authenticationManager.authenticate(tokenAuthentication);
		SecurityContextHolder.getContext().setAuthentication(authenticated);
		filterChain.doFilter(request, response);

	}

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		return request.getServletPath().equals("/login");
	}

}
