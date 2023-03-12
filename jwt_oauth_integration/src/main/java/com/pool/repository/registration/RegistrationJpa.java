package com.security.repository.registration;

import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.security.model.Registration;

@Repository
public interface RegistrationJpa extends JpaRepository<Registration, Integer>, RegistrationDao {
	Optional<Registration> findByUserName(String userName);
	boolean existsByUserName(String username);
}
