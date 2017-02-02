package io.srushti.movieflex_apii.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import io.srushti.movieflex_apii.entity.User;
import io.srushti.movieflex_apii.exception.BadRequestException;
import io.srushti.movieflex_apii.exception.EntityNotFoundException;
import io.srushti.movieflex_apii.repository.UserRepository;
@Service
@EnableTransactionManagement
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository user_repo;

	@Override
	@Transactional
	public User create(User user) {
		User user1 = user_repo.findByEmail(user.getEmail());
		if (user1!=null)
			throw new BadRequestException("User email is already existing");
		return user_repo.create(user);
	}

	@Override
	@Transactional
	public User update(String id, User user) {
		User user1 = user_repo.findOne(id);
		if (user1==null)
			throw new EntityNotFoundException("User not found");
		return user_repo.update(user);
	}

	@Override
	@Transactional
	public void delete(String id) {
		User user1 = user_repo.findOne(id);
		if (user1==null)
			throw new EntityNotFoundException("User not found");
		user_repo.delete(user1);

	}

}
