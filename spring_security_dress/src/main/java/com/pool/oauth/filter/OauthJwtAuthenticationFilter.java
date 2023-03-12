package com.pool.oauth.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.security.oauth.config.OauthJwtTokenProvider;
import com.security.oauth.constants.OAuthConstants;

@Component
public class OauthJwtAuthenticationFilter extends OncePerRequestFilter{

	@Autowired
	private OauthJwtTokenProvider oauthJwtTokenProvider;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		System.out.println("fuck:"+request.getRequestURL());
		List<String> bypassUrls=OAuthConstants.bypassUrls();
		String currentUrl=request.getRequestURL().toString();
		boolean isBypassUrl= bypassUrls.stream().anyMatch(url->currentUrl.contains(url));
		if(request.getMethod().equalsIgnoreCase(OAuthConstants.OAUTH_TOKEN_OPTIONS_HTTP_METHOD) || isBypassUrl) {
			response.setStatus(HttpStatus.OK.value());
		}else {
			///Changing logic to hrader;
			String authorizationHeader=request.getHeader(OAuthConstants.OAUTH_TOKEN_HEADER);
			//String authorizationHeader=request.getHeader(HttpHeaders.AUTHORIZATION);
			if(authorizationHeader==null ||  ! authorizationHeader.startsWith(OAuthConstants.OAUTH_TOKEN_PREFIX)) {
				filterChain.doFilter(request, response);
				return;
			}
			String oauthJwtToken=jwtTokenExtractorHttpServletRequest(request);
			String username=oauthJwtTokenProvider.oauthTokenSubjectExtractor(oauthJwtToken);
			if(oauthJwtTokenProvider.oauthTokenValidationVerifier(username, oauthJwtToken)&& SecurityContextHolder.getContext().getAuthentication()==null) {
				List<GrantedAuthority> authorities=oauthJwtTokenProvider.oauthAuthoritiesExtractor(oauthJwtToken);
				Authentication oauthAuthentication=oauthJwtTokenProvider.oauthAuthentication(username, authorities, request);
				SecurityContextHolder.getContext().setAuthentication(oauthAuthentication);
			}else {
				SecurityContextHolder.clearContext();
			}
		}
		filterChain.doFilter(request, response);
	}
	
	public String jwtTokenExtractorHttpServletRequest(HttpServletRequest request) {
		//String oauthJwtToken=request.getHeader(HttpHeaders.AUTHORIZATION);
		String oauthJwtToken=request.getHeader(OAuthConstants.OAUTH_TOKEN_HEADER);
		if(StringUtils.isNotBlank(oauthJwtToken) && oauthJwtToken.startsWith(OAuthConstants.OAUTH_TOKEN_PREFIX)) {
			return oauthJwtToken.substring(7, oauthJwtToken.length());
		}else {
			return null;
		}
		
	}

}
