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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	
	@OneToOne
	private User user;
	
	@OneToMany(mappedBy="cart")
	private Set<CartItems> cartItems;
	
	private static ShoppingCart cart;
	
	public ShoppingCart() {
		
	}
	
	public ShoppingCart(User user) {
		this.user=user;
	}

	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public Set<CartItems> getCartItems() {
		return cartItems;
	}



	public void setCartItems(Set<CartItems> cartItems) {
		this.cartItems = cartItems;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public double calcTotalCost() {
		double total = 0.0;
		
		ArrayList<CartItems> cart_items = new ArrayList<CartItems>();
		cart_items.addAll(this.getCartItems());
		
		for(int i=0;i<cart_items.size();i++) {
			Item item = cart_items.get(i).getItem();
			total += (item.getPrice()*cart_items.get(i).getAmount());
		}
		
		return total;
	}
	
	public boolean pay(PaymentMethod method) {
		double totalCost = calcTotalCost();
		return method.pay(totalCost);
	}
	
	public static ShoppingCart getInstance(User user) {
		if(cart == null) {
			cart = new ShoppingCart(user);
		}
		return cart;
		
	}
	
}
