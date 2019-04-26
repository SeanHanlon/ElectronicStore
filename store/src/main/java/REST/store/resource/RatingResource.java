package REST.store.resource;

import javax.ws.rs.Path;

import REST.store.service.CartItemsService;
import REST.store.service.ItemService;
import REST.store.service.PurchaseService;
import REST.store.service.ShoppingCartService;
import REST.store.service.UserService;

@Path("/ratings")
public class RatingResource {
	
	PurchaseService purchaseService = new PurchaseService();
	UserService userService = new UserService();
	ItemService itemService = new ItemService();
	ShoppingCartService cartService = new ShoppingCartService();
	CartItemsService cartItemsService = new CartItemsService();

}
