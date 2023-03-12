package com.pool.config.filter;

import java.io.IOException;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.pool.config.authentication.CustomAuthentication;

public class CustomAuthenticationFilter implements Filter {

	private AuthenticationManager authenticationManager;

	public CustomAuthenticationFilter(AuthenticationManager authenticationManager) {
		super();
		this.authenticationManager = authenticationManager;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String authorization = httpServletRequest.getHeader("Authorization");
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		try {
			CustomAuthentication authentication = new CustomAuthentication(authorization, null);
			
			Authentication result = authenticationManager.authenticate(authentication);
			if (result.isAuthenticated()) {
				SecurityContextHolder.getContext().setAuthentication(result);
				chain.doFilter(request, response);
			} else {
				httpServletResponse.setStatus(HttpStatus.FORBIDDEN.value());
			}
		} catch (AuthenticationException e) {
			httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }
		

	}
}
