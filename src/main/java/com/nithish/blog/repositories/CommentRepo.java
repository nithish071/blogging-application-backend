package com.nithish.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nithish.blog.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer> {

}
