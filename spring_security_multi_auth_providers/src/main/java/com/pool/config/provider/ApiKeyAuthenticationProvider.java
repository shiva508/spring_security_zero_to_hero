package com.pool.config.provider;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import com.pool.config.authentication.ApiKeyAuthentication;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ApiKeyAuthenticationProvider implements AuthenticationProvider {

    private final String key;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        ApiKeyAuthentication apiKeyAuthentication = (ApiKeyAuthentication) authentication;
        if (key.equals(apiKeyAuthentication.getKey())) {
            apiKeyAuthentication.setAuthenticated(true);
            return apiKeyAuthentication;
        } else {
            throw new BadCredentialsException("Bad Credentials");
        }
    }
    @Override
    public boolean supports(Class<?> authentication) {
        return ApiKeyAuthentication.class.equals(authentication);
    }
}
