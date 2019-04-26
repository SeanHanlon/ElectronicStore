package REST.store.model;

import java.util.HashSet;
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
	@NamedQuery(name = "Purchase.findAll", query = "select o from Purchase o"),
	@NamedQuery(name = "Purchase.findById", query = "select o from Purchase o where o.id=:id ")
})

@XmlRootElement
@Entity
public class Purchase {
	
	@Id
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "purchase_content", joinColumns = {
			@JoinColumn(name = "purchase_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "item_id", referencedColumnName = "id") })
	@ElementCollection(targetClass = Item.class)
	private Set<Item> purchase_content;
	
	private double total;
	private String payMethod;
	private String address;
	
	public Purchase() {
		
	}
	
	public Purchase(User user, Set<Item> purchase_content, double total) {
		this.user=user;
		this.purchase_content=purchase_content;
		this.total=total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Item> getPurchase_content() {
		return purchase_content;
	}

	public void setPurchase_content(Set<Item> purchase_content) {
		this.purchase_content = purchase_content;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public boolean pay(PaymentMethod method, ShoppingCart cart) {
		double totalCost = cart.calcTotalCost();
		return method.pay(totalCost);
	}
	
	
	

}
