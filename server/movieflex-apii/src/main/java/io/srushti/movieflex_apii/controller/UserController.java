package io.srushti.movieflex_apii.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.srushti.movieflex_apii.entity.User;
import io.srushti.movieflex_apii.service.UserService;

@RestController
@RequestMapping(value = "users")

public class UserController {
	
	@Autowired
	private UserService user_service;
	
	@RequestMapping( method = RequestMethod.POST)
	public User create(@RequestBody User user){
		return user_service.create(user);
	}
	
	@RequestMapping( method = RequestMethod.PUT, value = "{id}")	
	public User update(@PathVariable("id")String id, @RequestBody User user){
		return user_service.update(id, user);
	}
	
	@RequestMapping( method = RequestMethod.DELETE, value = "{id}")	
	public void delete(@PathVariable("id")String id){
		user_service.delete(id);
	}
}