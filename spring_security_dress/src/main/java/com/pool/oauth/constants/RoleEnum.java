package com.pool.oauth.constants;

public enum RoleEnum {
	ROLE_USER(Authority.USER_AUTHORITIES),
	ROLE_CUSTOMER(Authority.CUSTOMER_AUTHORITIES);
	private String[] authorities;

	private RoleEnum(String ...authorities) {
		this.authorities = authorities;
	}

	public String[] getAuthorities() {
		return authorities;
	}
	
}
