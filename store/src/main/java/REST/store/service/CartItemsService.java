package REST.store.service;

import REST.store.model.CartItems;
import REST.store.persistence.PersistenceUtil;

public class CartItemsService {
	
	public CartItemsService() {
		
	}
	
	public void saveCartItems(CartItems cartItems) {
		PersistenceUtil.persist(cartItems);
	}

}
