package REST.store.resource;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import REST.store.model.CartItems;
import REST.store.model.Item;
import REST.store.model.Purchase;
import REST.store.model.PurchaseFacadeImp;
import REST.store.model.ShoppingCart;
import REST.store.model.User;
import REST.store.model.Visa;
import REST.store.service.CartItemsService;
import REST.store.service.ItemService;
import REST.store.service.PurchaseService;
import REST.store.service.ShoppingCartService;
import REST.store.service.UserService;

@Path("/purchase")
public class PurchaseResource {
	
	PurchaseService purchaseService = new PurchaseService();
	UserService userService = new UserService();
	ItemService itemService = new ItemService();
	ShoppingCartService cartService = new ShoppingCartService();
	CartItemsService cartItemsService = new CartItemsService();
	
	/*@GET
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Purchase getPurchase(@FormParam(value="cartId") int id) {
		ShoppingCart cart = cartService.findById(id);
		ArrayList<CartItems> cart_items = new ArrayList<CartItems>();
		cart_items.addAll(cart.getCartItems());
		double total = cart.calcTotalCost();
		Set<Item> items = new HashSet<>();
		
		for(int i=0;i<cart_items.size();i++) {
			CartItems cartItem = cart_items.get(i);
			Item item = itemService.getItemById(cartItem.getItem().getId());
			items.add(item);
		}
		
		
		
	}*/
	
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void makePurchase(@FormParam(value="userId") int id, @FormParam(value="total") double total,
			HttpServletRequest request) {
		User user = userService.getUserById(id);
		Set<Item> items = new HashSet<>();
		ShoppingCart cart = user.getCart();
		ArrayList<CartItems> cart_items = new ArrayList<CartItems>();
		cart_items.addAll(cart.getCartItems());
		PurchaseFacadeImp purchaseFacade = new PurchaseFacadeImp();
		
		if(purchaseFacade.placeOrder(cart_items)) {
			items.addAll(items);
			Purchase purchase = new Purchase(user, items, total);
			
			if(request.getParameter("payment_method").equals("Visa")) {
				
				Visa visa = new Visa(request.getParameter("name"), request.getParameter("cardNumber"),
						request.getParameter("expires"));
				
				if(purchase.pay(visa, cart)) {
					purchase.setPayMethod("Visa");
					purchase.setAddress(user.getAddress());
					purchaseService.addPurchase(purchase);
					itemService.updateStock(cart_items);
					cartItemsService.emptyCart(cartItemsService.findByCartId(cart.getId()));
					
				}
			}
		}
		
	}

}
