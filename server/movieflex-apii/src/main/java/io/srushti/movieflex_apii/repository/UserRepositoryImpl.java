package io.srushti.movieflex_apii.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import io.srushti.movieflex_apii.entity.User;
@Repository
public class UserRepositoryImpl implements UserRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public User findOne(String id) {
		return em.find(User.class, id);
	}

	@Override
	public User findByEmail(String email) {
		TypedQuery<User> query = em.createNamedQuery("User.findbyEmail", User.class);
		query.setParameter("uEmail", email);
		List<User> userlist = query.getResultList();
		if(userlist != null && userlist.size()==1)
			return userlist.get(0);
			else
				return null;
	}

	@Override
	public User create(User user) {
		em.persist(user);
		return user;
	}

	@Override
	public User update(User user) {
		em.merge(user);
		return user;
	}

	@Override
	public void delete(User user) {
		em.remove(user);

	}

}
