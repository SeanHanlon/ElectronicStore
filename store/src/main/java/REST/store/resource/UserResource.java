package REST.store.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import REST.store.service.UserService;
import REST.store.model.User;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
	
	UserService userService = new UserService();
	
	@GET
	public List<User> getUsers() {
		return userService.getAllUsers();
	}
	
	@POST
	public void addUser(User user) {
		userService.addUser(user);
	}

}
