package io.srushti.movieflex_apii.service;

import io.srushti.movieflex_apii.entity.Comment;

public interface CommentService {
	
//	public List<Comment> findAll();
//	public Comment findOne(String id);
	public Comment create(Comment cmt);
	public Comment update(String id, Comment user);
	public void delete(String id);


}
