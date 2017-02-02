package io.srushti.movieflex_apii.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import io.srushti.movieflex_apii.entity.MovieInfo;

@Repository
public class MovieInfoRepositoryImpl implements MovieInfoRepository {

	@PersistenceContext
	private EntityManager em;
	@Override
	public List<MovieInfo> findAll() {
		TypedQuery<MovieInfo> query = em.createNamedQuery("Movie.findALL", MovieInfo.class);
		return query.getResultList();
	}

	@Override
	public MovieInfo findOne(String id) {
		return em.find(MovieInfo.class, id);
	}

	@Override
	public MovieInfo findByName(String name) {
		TypedQuery<MovieInfo> query = em.createNamedQuery("Movie.findbyName", MovieInfo.class);
		query.setParameter("mName", name);
		List<MovieInfo> movielist = query.getResultList();
		if(movielist != null && movielist.size()==1)
			return movielist.get(0);
			else
				return null;
	}

	@Override
	public MovieInfo create(MovieInfo mov) {
		em.persist(mov);
		return mov;
	}

	@Override
	public MovieInfo update(MovieInfo mov) {
		em.merge(mov);
		return mov;
	}

	@Override
	public void delete(MovieInfo mov) {
		em.remove(mov);

	}

}
