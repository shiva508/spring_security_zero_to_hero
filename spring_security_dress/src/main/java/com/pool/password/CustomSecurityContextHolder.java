package com.pool.password;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class CustomSecurityContextHolder {
	public Map<Object, Object> customSecurityContextHolder() {
		Map securityContextDetails=new HashMap<>();
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		securityContextDetails.put("user_name", authentication.getName());
		securityContextDetails.put("password", authentication.getPrincipal());
		securityContextDetails.put("Grants", authentication.getAuthorities());
		return securityContextDetails;
	}
}
