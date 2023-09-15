package com.pool.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.oauth2.server.authorization.client.JdbcRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import java.util.Set;
import java.util.UUID;

@Configuration
public class ClientConfiguration {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public RegisteredClientRepository registeredClientRepository(JdbcTemplate jdbcTemplate){
        return new JdbcRegisteredClientRepository(jdbcTemplate);
    }
    @Bean
    ApplicationRunner clientRunner(RegisteredClientRepository clientRepository){
        return args -> {
            String clientId="client";
            String secretCd="secret";
            if (clientRepository.findByClientId(clientId) == null) {
                RegisteredClient registeredClient=RegisteredClient.withId(UUID.randomUUID().toString())
                        .clientId(clientId)
                        .clientSecret(passwordEncoder.encode(secretCd))
                        .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                        .authorizationGrantTypes(authorizationGrantTypes -> authorizationGrantTypes.addAll(Set.of(AuthorizationGrantType.AUTHORIZATION_CODE,
                                                                                                                  AuthorizationGrantType.CLIENT_CREDENTIALS,
                                                                                                                  AuthorizationGrantType.REFRESH_TOKEN)))
                        .redirectUri("http://127.0.0.1:8042/login/oauth2/code/spring")
                        .scopes(scopes -> scopes.addAll(Set.of("user.read","user.write", OidcScopes.OPENID)) )
                        .build();
                clientRepository.save(registeredClient);

            }
        };
    }
}
