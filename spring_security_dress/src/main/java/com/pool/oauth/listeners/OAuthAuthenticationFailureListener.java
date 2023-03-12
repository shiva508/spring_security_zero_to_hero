package com.pool.oauth.listeners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;

import com.security.oauth.service.LoginAttemptService;

@Component
public class OAuthAuthenticationFailureListener {

	@Autowired
	private LoginAttemptService loginAttemptService;
	
	@EventListener
	public void onAuthenticationFailureEvent(AuthenticationFailureBadCredentialsEvent failureEvent) {
		Object principal=failureEvent.getAuthentication().getPrincipal();
		if(principal instanceof String) {
			String username=(String) failureEvent.getAuthentication().getPrincipal();
			loginAttemptService.addUserToLoginAttemptCache(username);
		}
	}
}
