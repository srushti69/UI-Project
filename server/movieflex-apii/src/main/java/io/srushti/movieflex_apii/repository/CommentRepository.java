package io.srushti.movieflex_apii.repository;

import io.srushti.movieflex_apii.entity.Comment;

public interface CommentRepository {
	
	//public List<Comment> findAll();
	public Comment findOne(String id);
	public Comment create(Comment cmt);
	public Comment update(Comment cmt);
	public void delete(Comment cmt);

}
