package com.pool.utils;

public enum USER_PERMISIONS {
	MANAGER_READ("manager:read"),
	ADMIN_READ("admin:read"),
	ADMIN_WRITE("admin:write");

	private final String permission;

	private USER_PERMISIONS(String permission) {
		this.permission = permission;
	}

	public String getPermission() {
		return permission;
	}
	
}
