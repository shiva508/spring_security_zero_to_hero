package com.pool.config.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationProvider;

@Configuration
public class MessageChannelSecurityConfig {

    @Bean
    JwtDecoder jwtDecoder(@Value("${spring.security.oauth2.authorizationserver.issuer}") String issuerUri) {
        return NimbusJwtDecoder.withIssuerLocation(issuerUri).build();
    }

    @Bean
    JwtAuthenticationConverter jwtAuthenticationConverter() {
        return new JwtAuthenticationConverter();
    }

    @Bean
    JwtAuthenticationProvider authenticationProvider(JwtDecoder jwtDecoder) {
        return new JwtAuthenticationProvider(jwtDecoder);
    }
}
