package REST.store.resource;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import REST.store.service.UserService;
import REST.store.model.User;

@Path("/users")
public class UserResource {
	
	UserService userService = new UserService();
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers() {
		return userService.getAllUsers();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void addUser(User user) {
		userService.addUser(user);
	}
	
	@Context
	private HttpServletRequest request;
	@POST
	@Path("/login")
	public void login(String email, String password) {
		User user = userService.loginUser(email, password);
		
		if (user == null)
		{
			System.out.println("cannot find user");
		}
		else
		{
			request.getSession().setAttribute("user", user);
			request.setAttribute("customer", user);
		}
	}

}
