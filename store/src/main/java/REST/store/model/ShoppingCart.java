package REST.store.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

@NamedQueries( {
	@NamedQuery(name = "Cart.findById", query = "select o from ShoppingCart o where o.id=:id ")
})

@XmlRootElement
@Entity
public class ShoppingCart {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	//TODO add relationship between items and cart
	//@ManyToOne
	private final List<Item> items;
	
	
	/*@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "cart_items", joinColumns = {
			@JoinColumn(name = "cartId", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "item_id", referencedColumnName = "id") })
	@ElementCollection(targetClass = Item.class)
	private Set<Item> cart_items = new HashSet<Item>();*/
	
	/*public ShoppingCart() {
		
	}*/
	
	public ShoppingCart() {
		items = new ArrayList<Item>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public void addItem(Item item) {
		items.add(item);
	}
	
	public void removeItem(Item item) {
		items.remove(item);
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
