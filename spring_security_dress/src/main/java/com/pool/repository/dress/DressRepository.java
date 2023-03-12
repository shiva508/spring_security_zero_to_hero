package com.pool.repository.dress;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.dress.model.DressModel;

@Repository
public interface DressRepository extends JpaRepository<DressModel, Integer> {

}
