package com.pool.controller.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.model.Role;
import com.security.service.role.RoleService;

@RestController
@RequestMapping("/role/")
public class RoleController {
@Autowired
private RoleService roleService;

@PostMapping("/save")
public Role saveRole(@RequestBody Role role) {
	return roleService.saveRoles(role);
}
@GetMapping("/roles")
public List<Role> getAllRoles(){
	return roleService.getAllRoles();
}
}
