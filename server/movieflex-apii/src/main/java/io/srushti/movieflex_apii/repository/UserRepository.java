package io.srushti.movieflex_apii.repository;

import io.srushti.movieflex_apii.entity.User;

public interface UserRepository {

	public User findOne(String id);
	public User findByEmail(String email);
	public User create(User user);
	public User update(User user);
	public void delete(User user);
}
