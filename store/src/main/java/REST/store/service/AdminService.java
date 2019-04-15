package REST.store.service;

import java.util.List;

import REST.store.model.Admin;
import REST.store.model.User;
import REST.store.persistence.PersistenceUtil;

public class AdminService {
	
	public AdminService() {
		
	}

	public List<Admin> getAllAdmins() {
		List<Admin> admins = PersistenceUtil.findAllAdmins();
		return admins;
	}
	
	public void addAdmin(Admin admin) {
		PersistenceUtil.persist(admin);
	}
}
