package com.pool.oauth.service;

import org.springframework.stereotype.Service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import static java.util.concurrent.TimeUnit.MINUTES;

import java.util.concurrent.ExecutionException;

@Service
public class LoginAttemptService {

	public static final Integer MAXIMUM_NUMMBER_OF_LOGING_ATTEMPTS = 5;
	public static final Integer ATTEMPTS_INCREAMENT = 1;

	private LoadingCache<String, Integer> loginAttemptCache;

	public LoginAttemptService() {
		super();
		loginAttemptCache = CacheBuilder.newBuilder().expireAfterAccess(15, MINUTES).maximumSize(100)
				.build(new CacheLoader<String, Integer>() {
					@Override
					public Integer load(String key) throws Exception {
						return 0;
					}
				});
	}

	public void evictUserFromLoginAttemptCache(String username) {
		loginAttemptCache.invalidate(username);
	}

	public void addUserToLoginAttemptCache(String username) {
		int attempts = 0;
		try {
			attempts = ATTEMPTS_INCREAMENT + loginAttemptCache.get(username);
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		loginAttemptCache.put(username, attempts);
	}

	public boolean hasExceededMaxAttempts(String username) {
		try {
			return loginAttemptCache.get(username) >= MAXIMUM_NUMMBER_OF_LOGING_ATTEMPTS;
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return false;
	}

}
