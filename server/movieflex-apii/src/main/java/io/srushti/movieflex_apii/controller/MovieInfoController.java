package io.srushti.movieflex_apii.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.srushti.movieflex_apii.entity.MovieInfo;
import io.srushti.movieflex_apii.service.MovieService;
@RestController
@RequestMapping(value = "movies")

public class MovieInfoController {
	
	@Autowired
	private MovieService mov_service;

	@RequestMapping( method = RequestMethod.GET)
	public List<MovieInfo> findAll(){
		return mov_service.findAll();
	}
	
	@RequestMapping( method = RequestMethod.GET, value = "{imdbid}")
	public MovieInfo findOne(@PathVariable("imdbid")String imdbId){
		return mov_service.findOne(imdbId);
	}
	
	@RequestMapping( method = RequestMethod.POST)
	public MovieInfo create(@RequestBody MovieInfo mov){
		return mov_service.create(mov);
	}
	
	@RequestMapping( method = RequestMethod.PUT, value = "{imdbid}")	
	public MovieInfo update(@PathVariable("imdbid")String imdbId, @RequestBody MovieInfo mov){
		return mov_service.update(imdbId, mov);
	}
	
	@RequestMapping( method = RequestMethod.DELETE, value = "{id}")	
	public void delete(@PathVariable("id")String imdbId){
		mov_service.delete(imdbId);
	}
}
