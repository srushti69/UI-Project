package io.srushti.movieflex_apii.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.srushti.movieflex_apii.entity.Comment;
import io.srushti.movieflex_apii.service.CommentService;
@RestController
@RequestMapping(value = "comments")

public class CommentController {
	
	@Autowired
	private CommentService cmt_service;
	
	@RequestMapping( method = RequestMethod.POST)
	public Comment create(@RequestBody Comment cmt){
		return cmt_service.create(cmt);
	}
	
	@RequestMapping( method = RequestMethod.PUT, value = "{id}")	
	public Comment update(@PathVariable("id")String cmt_id, @RequestBody Comment cmt){
		return cmt_service.update(cmt_id, cmt);
	}
	
	@RequestMapping( method = RequestMethod.DELETE, value = "{id}")	
	public void delete(@PathVariable("id")String cmt_id){
		cmt_service.delete(cmt_id);
	}
}

