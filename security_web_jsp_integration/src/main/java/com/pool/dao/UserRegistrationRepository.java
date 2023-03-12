package com.pool.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pool.model.UserRegistration;
@Repository
public interface UserRegistrationRepository extends JpaRepository<UserRegistration, Integer> {

}
