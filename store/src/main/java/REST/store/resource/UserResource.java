package REST.store.resource;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import REST.store.service.UserService;
import REST.store.model.User;

@Path("/users")
public class UserResource {
	
	UserService userService = new UserService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<User> getUsers() {
		return userService.getAllUsers();
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/addUser")
	public void addUser(@FormParam(value = "name") String name, @FormParam(value = "email") String email,
			@FormParam(value = "password") String password, @FormParam(value = "address") String address) {
		System.out.println(name);
		User user = new User(name, email, password, address, null);
		userService.addUser(user);
	}
	
	@Context
	private HttpServletRequest request;
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/login")
	public void login(@FormParam(value = "email") String email, @FormParam(value = "password") String password) {
		User user = userService.loginUser(email, password);
		
		if (user == null)
		{
			System.out.println("cannot find user");
		}
		else
		{
			request.getSession().setAttribute("user", user);
			request.setAttribute("customer", user);
			request.getSession().setAttribute("name", user.getId());
			System.out.println(request.getSession().getAttribute("name")+" is logged in");
		}
	}
	
	@POST
	@Path("/logout")
	public void logout() {
		request.getSession().setAttribute("user", null);
		request.setAttribute("customer", null);
	}
	
	@DELETE
	@Path("/{userID}")
	public void deleteUser(@PathParam("userId") int id) {
		userService.removeUser(id);
	}
	
	
}
