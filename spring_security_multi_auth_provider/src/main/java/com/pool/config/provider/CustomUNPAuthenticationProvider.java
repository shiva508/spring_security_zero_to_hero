package com.pool.config.provider;

import com.pool.config.authentication.UsernamePasswordAuthentication;
import com.pool.util.StudentpoolConstents;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomUNPAuthenticationProvider implements AuthenticationProvider {

    private final UserDetailsService jpaUserDetailsService;


    public CustomUNPAuthenticationProvider(@Qualifier("jpaUserDetailsService") UserDetailsService jpaUserDetailsService) {
        this.jpaUserDetailsService = jpaUserDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        UserDetails userDetails = jpaUserDetailsService.loadUserByUsername(username);
        if (userDetails.getPassword().equals(password)) {
            return new UsernamePasswordAuthentication(username, password, null);
        } else {
            throw new BadCredentialsException(StudentpoolConstents.BAD_CREDENTIALS);
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthentication.class.equals(authentication);
    }
}
