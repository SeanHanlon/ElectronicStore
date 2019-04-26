package REST.store.service;

import java.util.List;

import REST.store.model.Purchase;
import REST.store.model.User;
import REST.store.persistence.PersistenceUtil;

public class PurchaseService {
	
	public PurchaseService () {
		
	}

	public List<Purchase> getAllPurchases() {
		List<Purchase> purchases = PersistenceUtil.findAllPurchases();
		return purchases;
	}
	
	public void addPurchase(Purchase p) {
		PersistenceUtil.persist(p);
	}
	
	public Purchase getPurchaseById(int id) {
		return PersistenceUtil.findPurchaseById(id);
	}
}
