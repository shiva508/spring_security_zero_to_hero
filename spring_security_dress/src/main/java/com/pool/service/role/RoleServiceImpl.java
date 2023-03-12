package com.pool.service.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.security.model.Role;
import com.security.repository.role.RoleRepository;
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	@Transactional
	public Role saveRoles(Role role) {
		// TODO Auto-generated method stub
		return roleRepository.save(role);
	}

	@Override
	@Transactional
	public List<Role> getAllRoles() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}


}
