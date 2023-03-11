package com.pool.service;

import java.util.List;

import com.pool.entity.Post;

public interface PostService {
	public Post save(Post post);

	public List<Post> posts();

}
