package com.pool.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pool.entity.Post;
import com.pool.repository.PostRepository;

@Service
@Transactional
public class PostServiceImpl implements PostService {

	private final PostRepository postRepository;

	public PostServiceImpl(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	@Override
	public Post save(Post post) {
		return postRepository.saveAndFlush(post);
	}

	@Override
	public List<Post> posts() {
		return postRepository.findAll();
	}

}
