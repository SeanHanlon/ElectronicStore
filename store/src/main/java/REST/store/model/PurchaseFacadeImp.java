package REST.store.model;

import java.util.ArrayList;

import REST.store.service.CheckStock;

public class PurchaseFacadeImp implements PurchaseFacade {

	CheckStock checkStock = new CheckStock();
	
	public PurchaseFacadeImp() {
		
	}
	
	@Override
	public boolean placeOrder(ArrayList<CartItems> cart_items) {
		// TODO Auto-generated method stub
		boolean b = false;
		if(checkStock.isAvailable(cart_items)) {
			b=true;
		}
		return b;
	}
	
	

}
