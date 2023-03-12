package com.pool.oauth.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.security.oauth.constants.OAuthConstants;
import com.security.oauth.forms.UserPrinicipal;

@Component
public class OauthJwtTokenProvider {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Value("${OAUTH_SECRET}")
	private String secret;

	public String oauthTokenGenerator(UserPrinicipal userPrinicipal) {

		Algorithm signInAlgorithm = Algorithm.HMAC512(secret.getBytes());

		String[] oauthClaims = userPrinicipalCliamsExtrator(userPrinicipal);

		String oauthToken = JWT
				.create()
				.withIssuer(OAuthConstants.OAUTH_TOKEN_GET_ARRAYS_LLC)//Provider
				.withAudience(OAuthConstants.OAUTH_TOKEN_GET_ARRAYS_ADMINISTRATION)//permission
				.withIssuedAt(new Date(System.currentTimeMillis()))//token generated time
				.withSubject(userPrinicipal.getUsername())//unique entity
				.withArrayClaim(OAuthConstants.OAUTH_TOKEN_AUTHORITIES, oauthClaims)//adding claims
				.withExpiresAt(new Date(System.currentTimeMillis() + OAuthConstants.OAUTH_TOKEN_EXPIRATION_TIME))//expiration
				.sign(signInAlgorithm);

		return oauthToken;
	}
	public String oauthRefreshTokenGenerator(UserPrinicipal userPrinicipal) {

		Algorithm signInAlgorithm = Algorithm.HMAC512(secret.getBytes());

		String[] oauthClaims = userPrinicipalCliamsExtrator(userPrinicipal);

		String oauthToken = JWT
				.create()
				.withIssuer(OAuthConstants.OAUTH_TOKEN_GET_ARRAYS_LLC)//Provider
				.withAudience(OAuthConstants.OAUTH_TOKEN_GET_ARRAYS_ADMINISTRATION)//permission
				.withIssuedAt(new Date(System.currentTimeMillis()))//token generated time
				.withSubject(userPrinicipal.getUsername())//unique entity
				.withArrayClaim(OAuthConstants.OAUTH_TOKEN_AUTHORITIES, oauthClaims)//adding claims
				.withExpiresAt(new Date(System.currentTimeMillis() + OAuthConstants.OAUTH_REFRESH_TOKEN_EXPIRATION_TIME))//expiration
				.sign(signInAlgorithm);

		return oauthToken;
	}

	public String[] userPrinicipalCliamsExtrator(UserPrinicipal userPrinicipal) {
		return userPrinicipal
				.getAuthorities()
				.stream()
				.map(authority -> authority.getAuthority())
				.collect(Collectors.toList())
				.toArray(String[]::new);
	}

	public List<GrantedAuthority> oauthAuthoritiesExtractor(String oauthToken) {
		String[] tokenClaims = oathtTokenCliamsExtrator(oauthToken);
		return Arrays
				.asList(tokenClaims)
				.stream()
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}

	public String[] oathtTokenCliamsExtrator(String oauthToken) {
		Algorithm signInAlgorithm = Algorithm.HMAC512(secret);
		JWTVerifier jwtVerifier=oauthJwtTokenVerifierInastance(signInAlgorithm);
		return  jwtVerifier
				.verify(oauthToken)
				.getClaim(OAuthConstants.OAUTH_TOKEN_AUTHORITIES)
				.asArray(String.class);
	}

	public JWTVerifier oauthJwtTokenVerifierInastance(Algorithm signInAlgorithm) {
		JWTVerifier jwtVerifier=null;
		try {
			jwtVerifier=JWT
							.require(signInAlgorithm)
							.withIssuer(OAuthConstants.OAUTH_TOKEN_GET_ARRAYS_LLC)
							.build();
		} catch (JWTVerificationException e) {
			throw new JWTVerificationException(OAuthConstants.OAUTH_TOKEN_CAN_NOT_BE_VERIFIED);
		}
		
		return jwtVerifier;
	}
	
	public Authentication oauthAuthentication(String userName,List<GrantedAuthority> authorities,HttpServletRequest request) {
		UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(userName, null, authorities);
		authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		return authenticationToken;
		
	}
	
	public boolean oauthTokenValidationVerifier(String userName,String oauthToken) {
		Algorithm signInAlgorithm = Algorithm.HMAC512(secret);
		JWTVerifier jwtVerifier=oauthJwtTokenVerifierInastance(signInAlgorithm);
		boolean isTokenValid=StringUtils.isNotEmpty(userName) && !oauthExpirationChecker(jwtVerifier,oauthToken);
		return isTokenValid;
	}

	public boolean oauthExpirationChecker(JWTVerifier jwtVerifier, String oauthToken) {
		Date expirationDate=jwtVerifier.verify(oauthToken).getExpiresAt();
		return expirationDate.before(new Date(System.currentTimeMillis()));
	}
	
	public String oauthTokenSubjectExtractor(String oauthToken) {
		Algorithm signInAlgorithm = Algorithm.HMAC512(secret);
		JWTVerifier jwtVerifier=oauthJwtTokenVerifierInastance(signInAlgorithm);
		return jwtVerifier.verify(oauthToken).getSubject();
	}

	public Authentication authenticate(String username, String password) {
		
		Authentication authentication =authenticationManager
				.authenticate(
						new UsernamePasswordAuthenticationToken(username, password)
							);
		return authentication;
	}

	public HttpHeaders generateJwtOauthHeader(UserPrinicipal userPrinicipal) {
		HttpHeaders headers=new HttpHeaders();
		headers.add(OAuthConstants.OAUTH_TOKEN_HEADER, oauthTokenGenerator(userPrinicipal));
		return headers;
	}
	
}
