package io.srushti.movieflex_apii.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import io.srushti.movieflex_apii.entity.MovieInfo;
import io.srushti.movieflex_apii.exception.BadRequestException;
import io.srushti.movieflex_apii.exception.EntityNotFoundException;
import io.srushti.movieflex_apii.repository.MovieInfoRepository;
@Service
@EnableTransactionManagement
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieInfoRepository mov_repo;
	@Override
	@Transactional(readOnly=true)
	public List<MovieInfo> findAll() {
		return mov_repo.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public MovieInfo findOne(String id) {
		MovieInfo mov = mov_repo.findOne(id);
		if(mov==null)
			throw new EntityNotFoundException("Movie not found");
		return mov;
	}

	@Override
	@Transactional
	public MovieInfo create(MovieInfo mov) {
		MovieInfo mov1 = mov_repo.findOne(mov.getImdbId());
		if(mov1!= null)
			throw new BadRequestException("Movie is already exist");
		return mov_repo.create(mov);
	}

	@Override
	@Transactional
	public MovieInfo update(String id, MovieInfo mov) {
		MovieInfo mov1 = mov_repo.findOne(id);
		if(mov1==null)
			throw new EntityNotFoundException("Movie not found");
		return mov_repo.update(mov);
	}

	@Override
	@Transactional
	public void delete(String id) {
		MovieInfo mov1 = mov_repo.findOne(id);
		if(mov1==null)
			throw new EntityNotFoundException("Movie not found");
		mov_repo.delete(mov1);

	}

}
