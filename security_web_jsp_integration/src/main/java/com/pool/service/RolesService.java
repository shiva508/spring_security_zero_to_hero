package com.pool.service;

import java.util.List;

import com.pool.model.Role;

public interface RolesService {
	public Role save(Role role);
	public List<Role> roles();
}
