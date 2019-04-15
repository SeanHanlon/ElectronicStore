package REST.store.service;

import java.util.List;

import REST.store.model.User;
import REST.store.persistence.PersistenceUtil;

public class UserService {

	public UserService() {
		
	}
	
	public List<User> getAllUsers() {
		List<User> users = PersistenceUtil.findAllUsers();
		return users;
	}
	
	public void addUser(User user) {
		PersistenceUtil.persist(user);
	}
}
