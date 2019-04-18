package REST.store.service;

import java.util.List;

import REST.store.model.Item;
import REST.store.model.User;
import REST.store.persistence.PersistenceUtil;

public class ItemService {
	
	public ItemService() {
		
	}
	
	public List<Item> getAllItems() {
		List<Item> items = PersistenceUtil.findAllItems();
		return items;
	}
	
	public void addItem(Item item) {
		PersistenceUtil.persist(item);
	}
	
	public Item getItemById(int id) {
		Item item = PersistenceUtil.findItemById(id);
		return item;
	}
	
	public List<Item> getItemByCategory(String category) {
		List<Item> found = PersistenceUtil.findItemByCategory(category);
		if(found!=null)
		{
			return found;
		}
		else {
			return null;
		}
	}
	
	public List<Item> getItemByManu(String manufacturer) {
		List<Item> found = PersistenceUtil.findItemByManu(manufacturer);
		if(found!=null)
		{
			return found;
		}
		else {
			return null;
		}
	}

	public List<Item> getItemByTitle(String title) {
		List<Item> found = PersistenceUtil.findItemByTitle(title);
		if(found!=null)
		{
			return found;
		}
		else {
			return null;
		}
	}
}
