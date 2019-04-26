package REST.store.service;

import java.util.ArrayList;

import REST.store.model.CartItems;
import REST.store.model.Item;

public class CheckStock {
	
	public CheckStock() {
		
	}
	
	public boolean isAvailable(ArrayList<CartItems> cart_items) {
		boolean available = true;
		
		for(int i=0;i<cart_items.size();i++) {
			CartItems cartItem = cart_items.get(i);
			Item item = cart_items.get(i).getItem();
			
			if(cartItem.getAmount() > item.getStockLevel())
			{
				available = false;
			}
		}
		
		return available;
	}

}
