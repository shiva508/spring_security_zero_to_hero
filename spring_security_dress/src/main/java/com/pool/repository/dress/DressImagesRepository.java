package com.pool.repository.dress;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.dress.model.DressImages;

@Repository
public interface DressImagesRepository extends JpaRepository<DressImages, Long> {
	
	public List<DressImages> findByDressCode(String dressCode);

}
