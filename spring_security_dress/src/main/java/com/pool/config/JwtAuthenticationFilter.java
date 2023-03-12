package com.pool.config;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.security.constants.DressConstants;
import com.security.model.User;
import com.security.service.user.CustomUserDetailsService;

public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	@Autowired
	private JWTTokenProvider jWTTokenProvider;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		try {
			String jwtToken=jwtTokenExtractorHttpServletRequest(request);
			if(StringUtils.hasText(jwtToken)&& jWTTokenProvider.validateJwtToken(jwtToken)) {
				Long userId=jWTTokenProvider.extractUserid(jwtToken);
				System.out.println("UserId:"+userId);
				User userDetals=customUserDetailsService.findByUserId(userId);
				UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(userDetals, null, Collections.emptyList());
				authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			}
		} catch (Exception e) {
		
		}
		filterChain.doFilter(request, response);
	}


	public String jwtTokenExtractorHttpServletRequest(HttpServletRequest request) {
		String jwtToken=request.getHeader(DressConstants.HEADER_STRING);
		if(StringUtils.hasText(jwtToken) && jwtToken.startsWith(DressConstants.TOKEN_PREFIX)) {
			return jwtToken.substring(7, jwtToken.length());
		}else {
			return null;
		}
		
	}

	
}
