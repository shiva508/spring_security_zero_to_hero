package com.pool.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pool.model.Former;
@Repository
public interface FormerRepository extends JpaRepository<Former, Integer> {

}
