package com.pool.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pool.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
