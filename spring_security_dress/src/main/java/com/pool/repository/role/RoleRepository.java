package com.pool.repository.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
