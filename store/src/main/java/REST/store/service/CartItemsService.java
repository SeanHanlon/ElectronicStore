package REST.store.service;

import java.util.List;

import REST.store.model.CartItems;
import REST.store.persistence.PersistenceUtil;

public class CartItemsService {
	
	public CartItemsService() {
		
	}
	
	public void saveCartItems(CartItems cartItems) {
		PersistenceUtil.persist(cartItems);
	}
	
	public void emptyCart(List<CartItems> list) {
		PersistenceUtil.remove(list);
	}
	
	public List<CartItems> findByCartId(int cartId) {
		return PersistenceUtil.findByCartId(cartId);
	}

}
