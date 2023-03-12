package com.pool.oauth.entrypoint;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.security.oauth.constants.OAuthConstants;
import com.security.oauth.payload.HttpResponse;
@Component
public class OauthJwtAthenticationEntryPoint extends Http403ForbiddenEntryPoint {
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authenticationException) throws IOException {
		HttpResponse httpResponse = new HttpResponse();
		httpResponse.setHttpStatus(HttpStatus.FORBIDDEN);
		httpResponse.setHttpStatusCode(HttpStatus.FORBIDDEN.value());
		httpResponse.setReason(HttpStatus.FORBIDDEN.getReasonPhrase().toUpperCase());
		httpResponse.setMessage(OAuthConstants.OAUTH_TOKEN_FORBIDDEN_MSG);
		httpResponse.setTimeStamp(new Date());
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		response.setStatus(HttpStatus.FORBIDDEN.value());
		String jsonLoginResponse = new Gson().toJson(httpResponse);
		response.getWriter().print(jsonLoginResponse);
	}
}
