package com.pool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pool.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
