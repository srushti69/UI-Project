package io.srushti.movieflex_apii.service;

import io.srushti.movieflex_apii.entity.User;

public interface UserService {
	
	//public List<User> findAll();
	//public User findByEmail(String email);
	public User create(User user);
	public User update(String id,User user);
	public void delete(String id);

}
