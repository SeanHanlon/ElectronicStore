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

}
