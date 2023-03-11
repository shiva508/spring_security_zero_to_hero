package com.pool.config.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.pool.config.authentication.CustomAuthentication;

public class CustomAuthenticationOncePerRequestFilter extends OncePerRequestFilter {

	private AuthenticationManager authenticationManager;

	public CustomAuthenticationOncePerRequestFilter(AuthenticationManager authenticationManager) {
		super();
		this.authenticationManager = authenticationManager;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String authorization = request.getHeader("Authorization");

		try {
			CustomAuthentication authentication = new CustomAuthentication(authorization, null);

			Authentication result = authenticationManager.authenticate(authentication);
			if (result.isAuthenticated()) {
				SecurityContextHolder.getContext().setAuthentication(result);
				filterChain.doFilter(request, response);
			} else {
				response.setStatus(HttpStatus.FORBIDDEN.value());
			}
		} catch (AuthenticationException e) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}

	}

}
