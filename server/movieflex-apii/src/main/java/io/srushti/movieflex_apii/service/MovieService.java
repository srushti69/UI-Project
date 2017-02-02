package io.srushti.movieflex_apii.service;

import java.util.List;
import io.srushti.movieflex_apii.entity.MovieInfo;

public interface MovieService {

	public List<MovieInfo> findAll();
	public MovieInfo findOne(String id);
	public MovieInfo create(MovieInfo mov);
	public MovieInfo update(String id, MovieInfo mov);
	public void delete(String id);
}
