package com.pool.repository.registration;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pool.model.Registration;

@Repository
public interface RegistrationJpa extends JpaRepository<Registration, Integer>, RegistrationDao {
	Optional<Registration> findByUserName(String userName);
	boolean existsByUserName(String username);
}
