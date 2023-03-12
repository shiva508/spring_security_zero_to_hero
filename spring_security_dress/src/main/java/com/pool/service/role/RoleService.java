package com.pool.service.role;

import java.util.List;

import com.security.model.Role;

public interface RoleService {
public Role saveRoles(Role role);

public List<Role> getAllRoles();
}
