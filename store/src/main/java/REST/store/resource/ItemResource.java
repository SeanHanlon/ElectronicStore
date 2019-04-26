package REST.store.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import REST.store.model.Item;
import REST.store.model.User;
import REST.store.persistence.PersistenceUtil;
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
			@FormParam(value = "stockLevel") int stockLevel) {
		Item item = new Item(title, manufacturer, price, category, stockLevel);
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
		
	@DELETE
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/deleteItem")
	public void deleteItem(@FormParam(value = "itemId") int id) {
		Item item = itemService.getItemById(id);
		PersistenceUtil.remove(item);
	}
	
}
