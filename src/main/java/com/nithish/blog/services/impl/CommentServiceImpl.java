package com.nithish.blog.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nithish.blog.entities.Comment;
import com.nithish.blog.entities.Post;
import com.nithish.blog.exceptions.ResourceNotFoundException;
import com.nithish.blog.payloads.CommentDto;
import com.nithish.blog.repositories.CommentRepo;
import com.nithish.blog.repositories.PostRepo;
import com.nithish.blog.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private PostRepo postRep;
	
	@Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public void deleteComment(Integer commentId) {
		Comment com = this.commentRepo.findById(commentId).orElseThrow(()->new ResourceNotFoundException("Comment","CommentId",commentId));
		this.commentRepo.delete(com);
	}
	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		Post post = this.postRep.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post", "post id", postId)); 
		
		Comment comment = this.modelMapper.map(commentDto,Comment.class);
		
		comment.setPost(post);
		
		
		
		Comment savedComment = this.commentRepo.save(comment);
		
		return this.modelMapper.map(savedComment, CommentDto.class);
		
		
	}

}
