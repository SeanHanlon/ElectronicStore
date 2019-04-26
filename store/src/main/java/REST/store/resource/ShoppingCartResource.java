package REST.store.resource;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import REST.store.model.CartItems;
import REST.store.model.Item;
import REST.store.model.ShoppingCart;
import REST.store.model.User;
import REST.store.service.CartItemsService;
import REST.store.service.ItemService;
import REST.store.service.ShoppingCartService;
import REST.store.service.UserService;

@Path("/cart")
public class ShoppingCartResource {
	
	ShoppingCartService cartService = new ShoppingCartService();
	UserService userService = new UserService();
	ItemService itemService = new ItemService();
	CartItemsService cartItemsService = new CartItemsService();
	
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
		ShoppingCart cart = user.getCart();
		
		if (item.getStockLevel() > 0) {
			ArrayList<CartItems> cart_items = new ArrayList<CartItems>();
			cart_items.addAll(cart.getCartItems());
			boolean b = true;
			
			for (int i =0;i<cart_items.size();i++) {
				CartItems current = cart_items.get(i);
				if(current.getItem() == item) {
					int temp = cart_items.get(i).getAmount();
					cart_items.get(i).setAmount(temp + 1);
					cartItemsService.saveCartItems(cart_items.get(i));
					Set<CartItems> updatedList = new HashSet<>(cart_items);
					cart.setCartItems(updatedList);
					b = false;
				}
			}
			
			if (b) {
				CartItems cartItems = new CartItems(cart, item, 1);
				cartItemsService.saveCartItems(cartItems);
				cart_items.add(cartItems);
				Set<CartItems> updatedList = new HashSet<>(cart_items);
				cart.setCartItems(updatedList);
			}
			
			cartService.saveCart(cart);
		}
		else {
			System.out.println("no stock");
		}
	}

}
