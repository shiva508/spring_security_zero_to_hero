package com.pool.oauth.service;

import com.security.oauth.model.SecureToken;

public interface SecureTokenService {
	SecureToken createSecureToken();
    void saveSecureToken(final SecureToken token);
    SecureToken findByToken(final String token);
    void removeToken(final SecureToken token);
    void removeTokenByToken(final String token);
}
