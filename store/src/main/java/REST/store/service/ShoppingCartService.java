package REST.store.service;

import REST.store.model.ShoppingCart;
import REST.store.persistence.PersistenceUtil;

public class ShoppingCartService {

	public ShoppingCartService() {
		
	}
	
	public void saveCart(ShoppingCart cart) {
		PersistenceUtil.persist(cart);
	}
}
