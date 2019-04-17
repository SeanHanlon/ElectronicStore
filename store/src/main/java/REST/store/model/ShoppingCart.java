package REST.store.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class ShoppingCart {
	
	private final List<Item> items;
	
	public ShoppingCart() {
		items = new ArrayList<Item>();
	}
	
	public void addItem(Item item) {
		items.add(item);
	}
	
	public double calcTotalCost() {
		double total = 0.0;
		
		for(Item item : items) {
			total += item.getPrice();
		}
		
		return total;
	}
	
	public boolean pay(PaymentMethod method) {
		double totalCost = calcTotalCost();
		return method.pay(totalCost);
	}

}
