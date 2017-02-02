package io.srushti.movieflex_apii.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import io.srushti.movieflex_apii.entity.Comment;

@Repository
public class CommentRepositoryImpl implements CommentRepository{

	@PersistenceContext
	private EntityManager em;
	@Override
	public Comment findOne(String id) {
		return em.find(Comment.class, id);
	}

	@Override
	public Comment create(Comment cmt) {
		em.persist(cmt);
		return cmt;
	}

	@Override
	public Comment update(Comment cmt) {
		em.merge(cmt);
		return cmt;
	}

	@Override
	public void delete(Comment cmt) {
		em.remove(cmt);

	}

}
