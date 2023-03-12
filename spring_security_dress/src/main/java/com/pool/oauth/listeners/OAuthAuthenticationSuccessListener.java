package com.pool.oauth.listeners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

import com.security.oauth.forms.UserPrinicipal;
import com.security.oauth.model.UserModel;
import com.security.oauth.service.LoginAttemptService;
@Component
public class OAuthAuthenticationSuccessListener {
	
	@Autowired
	private LoginAttemptService loginAttemptService;
	
	@EventListener
	public void onAuthenticationSuccessEvent(AuthenticationSuccessEvent successEvent) {
		Object principal=successEvent.getAuthentication().getPrincipal();
		if(principal instanceof UserPrinicipal) {
			UserPrinicipal userModel=(UserPrinicipal) successEvent.getAuthentication().getPrincipal();
			loginAttemptService.evictUserFromLoginAttemptCache(userModel.getUsername());
		}
	}
}
