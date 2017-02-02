package io.srushti.movieflex_apii.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import io.srushti.movieflex_apii.entity.Comment;
import io.srushti.movieflex_apii.exception.EntityNotFoundException;
import io.srushti.movieflex_apii.repository.CommentRepository;
@Service
@EnableTransactionManagement
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository cmt_repo;

	@Override
	@Transactional
	public Comment create(Comment cmt) {
		return cmt_repo.create(cmt);
	}

	@Override
	@Transactional
	public Comment update(String id, Comment cmt) {
		Comment cmt_existing = cmt_repo.findOne(id);
		if(cmt_existing==null)
			throw new EntityNotFoundException("Comment not found");
		return cmt_repo.update(cmt);
	}

	@Override
	@Transactional
	public void delete(String id) {
		Comment cmt_existing = cmt_repo.findOne(id);
		if(cmt_existing==null)
			throw new EntityNotFoundException("Comment not found");
		cmt_repo.delete(cmt_existing);
	}

}
