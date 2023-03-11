package com.pool.config.manager;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class TokenManager {
	
	public static ThreadLocal<Set<String>> threadLocal = new ThreadLocal<>();

	private Set<String> tokens = new HashSet<>();

	public boolean addToken(String token) {
		tokens.add(token);
		return true;
	}

	public boolean contains(String token) {
		return tokens.contains(token);
	}
}
