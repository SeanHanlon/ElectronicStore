package REST.store.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import REST.store.model.Admin;
import REST.store.model.User;
import REST.store.service.AdminService;

@Path("/admin")
public class AdminResource {
	
	AdminService adminService = new AdminService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/getAdmins")
	public List<Admin> getAdmins() {
		return adminService.getAllAdmins();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/addAdmin")
	public void addAdmin(@FormParam(value = "name") String name, @FormParam(value = "password") String password) {
		Admin admin = new Admin(name, password);
		adminService.addAdmin(admin);
	}

}
