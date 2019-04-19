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
import REST.store.model.User;
import REST.store.service.ItemService;

@Path("/items")
public class ItemResource {

	ItemService itemService = new ItemService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Item> getItems() {
		return itemService.getAllItems();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/addItem")
	public void addItem(@FormParam(value = "title") String title, @FormParam(value = "manufacturer") String manufacturer,
			@FormParam(value = "price") double price, @FormParam(value = "category") String category,
			@FormParam(value = "stockLevel") int stockLevel, @FormParam(value = "rating") int rating,
			@FormParam(value = "review") String review) {
		Item item = new Item(title, manufacturer, price, category, stockLevel, rating, review);
		itemService.addItem(item);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/searchByCategory")
	public List<Item> searchCategory(@FormParam(value = "searchCat") String category) {
		List<Item> items = itemService.getItemByCategory(category);
		if(items != null)
		{
			return items;
		}
		else
		{
			return null;
		}
		
	}
	
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/searchByManu")
	public List<Item> searchManu(@FormParam(value = "searchManu") String manufacturer) {
		List<Item> items = itemService.getItemByManu(manufacturer);
		if(items != null)
		{
			return items;
		}
		else
		{
			return null;
		}
		
	}
	
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/searchByTitle")
	public List<Item> searchTitle(@FormParam(value = "searchTitle") String title) {
		List<Item> items = itemService.getItemByTitle(title);
		if(items != null)
		{
			return items;
		}
		else
		{
			return null;
		}
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/addReview/{itemId}")
	public void addReview(@PathParam(value = "itemId") int id, @FormParam(value = "review") String review) {
		Item item = itemService.getItemById(id);
		
		if(item != null)
		{
			item.setReview(review);
		}
		else
		{
			System.out.println("cannot find item");
		}
		
	}
	
}
