package com.pool.config.manager;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import com.pool.config.provider.ApiKeyAuthenticationProvider;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CustomAuthenticationManager implements AuthenticationManager {

    private final String key;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        ApiKeyAuthenticationProvider provider = new ApiKeyAuthenticationProvider(key);
        if (provider.supports(authentication.getClass())) {
            return provider.authenticate(authentication);
        }
        return null;
    }
}
