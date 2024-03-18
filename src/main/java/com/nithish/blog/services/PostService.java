package com.nithish.blog.services;

import java.util.List;

import com.nithish.blog.payloads.PostDto;
import com.nithish.blog.payloads.PostResponse;

public interface PostService {
	
	// create
	PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
	
	//Update
	PostDto updatePost(PostDto postDto,Integer postId);
	
	// delete
	
	void deletePost(Integer postId);
	
	// get all posts
	
	PostResponse getAllPost(Integer pageNumber,Integer pageSize,String sortBy,String sortDir);
	
	// get single post
	PostDto getPostById(Integer postId);
	
	//get post by category
	
	List<PostDto> getPostsByCategory(Integer categoryId);
	
	// get all by user
	
	List<PostDto> getPostsByUser(Integer userId);
	
	// search Post
	List<PostDto> searchPosts(String keyword);
}
