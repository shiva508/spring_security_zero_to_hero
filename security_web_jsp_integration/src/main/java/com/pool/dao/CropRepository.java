package com.pool.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pool.model.Crop;
@Repository
public interface CropRepository extends JpaRepository<Crop, Integer> {

}
