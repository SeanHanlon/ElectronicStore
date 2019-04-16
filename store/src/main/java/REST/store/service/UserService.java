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
	
	public User loginUser(String email, String password) {
		User user = PersistenceUtil.findUserByEmail(email);
		
		if(user != null && user.getPassword().equals(password)
				&& user.getEmail().equals(email))
		{
			return user;
		}
		
		return null;
	}
	
	public void removeUser(int id) {
		User user = PersistenceUtil.findUserById(id);
		PersistenceUtil.remove(user);
	}
}
