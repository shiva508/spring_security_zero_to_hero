package com.pool.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.pool.dao.RoleRepository;
import com.pool.model.Role;
import com.pool.service.RolesService;

@Service
@Transactional
public class RolesServiceImpl implements RolesService {
	@Autowired
	RoleRepository rolesRepository;

	@Override
	public Role save(Role role) {
		return rolesRepository.save(role);
	}

	@Override
	public List<Role> roles() {
		return rolesRepository.findAll();
	}
}
