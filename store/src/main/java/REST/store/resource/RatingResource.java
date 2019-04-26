package REST.store.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import REST.store.model.Item;
import REST.store.model.Purchase;
import REST.store.model.Rating;
import REST.store.model.User;
import REST.store.service.CartItemsService;
import REST.store.service.ItemService;
import REST.store.service.PurchaseService;
import REST.store.service.RatingService;
import REST.store.service.ShoppingCartService;
import REST.store.service.UserService;

@Path("/ratings")
public class RatingResource {
	
	PurchaseService purchaseService = new PurchaseService();
	UserService userService = new UserService();
	ItemService itemService = new ItemService();
	ShoppingCartService cartService = new ShoppingCartService();
	CartItemsService cartItemsService = new CartItemsService();
	RatingService ratingService = new RatingService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Rating getRating(@FormParam(value="ratingId") int id) {
		Rating rating = ratingService.getRatingById(id);
		return rating;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void leaveRating(@FormParam(value="userId") int userId, @FormParam(value="review") String review,
			@FormParam(value="itemId") int itemId, @FormParam(value="rating") int rating) {
		User user = userService.getUserById(userId);
		Item item = itemService.getItemById(itemId);
		
		Rating theRating = new Rating(review, rating, user, item);
		
		theRating.setUser(user);
		theRating.setItem(item);
		ratingService.addRating(theRating);
		
	}

}
