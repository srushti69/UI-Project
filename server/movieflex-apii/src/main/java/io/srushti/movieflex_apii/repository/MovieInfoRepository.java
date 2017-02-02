package io.srushti.movieflex_apii.repository;

import java.util.List;

import io.srushti.movieflex_apii.entity.MovieInfo;

public interface MovieInfoRepository {

	public List<MovieInfo> findAll();
	public MovieInfo findOne(String id);
	public MovieInfo findByName(String name);
	public MovieInfo create(MovieInfo mov);
	public MovieInfo update(MovieInfo mov);
	public void delete(MovieInfo mov);

}
