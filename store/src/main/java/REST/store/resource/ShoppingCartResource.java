package REST.store.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import REST.store.model.ShoppingCart;
import REST.store.model.User;
import REST.store.service.ShoppingCartService;
import REST.store.service.UserService;

@Path("/cart")
public class ShoppingCartResource {
	
	ShoppingCartService cartService = new ShoppingCartService();
	UserService userService = new UserService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/getCart/{userId}")
	public ShoppingCart getCart(@PathParam("userId") int id) {
		User user = userService.getUserById(id);
		
		if(user != null)
		{
			return user.getCart();
		}
		else
		{
			return null;
		}
		
	}

}
