package com.pool.config.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.pool.config.authentication.ApiKeyAuthentication;
import com.pool.config.manager.CustomAuthenticationManager;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ApiKeyFilter extends OncePerRequestFilter {

	private String key;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String apiKey = request.getHeader("request-api-key");
		if (null == apiKey || apiKey.equals("null")) {
			filterChain.doFilter(request, response);
		} else {
			ApiKeyAuthentication authentication = new ApiKeyAuthentication(apiKey);
			CustomAuthenticationManager manager = new CustomAuthenticationManager(key);

			Authentication postAuthentication = manager.authenticate(authentication);
			if (postAuthentication.isAuthenticated()) {
				SecurityContextHolder.getContext().setAuthentication(postAuthentication);
				filterChain.doFilter(request, response);
			} else {
				response.setStatus(HttpStatus.UNAUTHORIZED.value());
			}
		}
	}
}
