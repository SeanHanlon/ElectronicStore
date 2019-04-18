package REST.store.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import REST.store.model.Item;
import REST.store.model.ShoppingCart;
import REST.store.model.User;
import REST.store.service.ItemService;
import REST.store.service.ShoppingCartService;
import REST.store.service.UserService;

@Path("/cart")
public class ShoppingCartResource {
	
	ShoppingCartService cartService = new ShoppingCartService();
	UserService userService = new UserService();
	ItemService itemService = new ItemService();
	
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
	
	//@Path("/addItem/{userId}/{itemId}")
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/addItem")
	public void addItem(@FormParam(value = "userId") int userId, @FormParam(value = "itemId") int itemId) {
		System.out.println(userId + itemId);
		User user = userService.getUserById(userId);
		Item item = itemService.getItemById(itemId);
		if(item != null)
		{
			System.out.println(user.getName() + " " + item.getManufacturer());
			user.getCart().addItem(item);
		}
		else
		{
			System.out.println("item empty");
		}
		
		//user.getCart().addItem(item);
		//User user = new User(name, email, password, address);
		//userService.addUser(user);
	}

}
