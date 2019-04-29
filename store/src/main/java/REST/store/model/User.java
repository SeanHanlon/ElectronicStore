package REST.store.model;

import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

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
import javax.persistence.NamedQueries;

@NamedQueries( {
	@NamedQuery(name = "User.findAllUsers", query = "select o from User o"),
	@NamedQuery(name = "User.findByEmail", query = "select o from User o where o.email=:email "),
	@NamedQuery(name = "User.findById", query = "select o from User o where o.id=:id ")
})

@XmlRootElement
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String name;
	private String email;
	private String password;
	private String address;
	
	@OneToMany
	@JoinColumn(name = "user_id")
	private Set<Purchase> purchases;
	
	@OneToOne(fetch=FetchType.LAZY, optional=false, mappedBy="user")
	private ShoppingCart cart;
	
	@OneToMany
	@JoinColumn(name = "user_id")
	private Set<Rating> ratings;
	
	public User() {
		
	}
	
	public User(String name, String email, String password, String address) {
		this.name=name;
		this.email=email;
		this.password=password;
		this.address=address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ShoppingCart getCart() {
		return cart;
	}

	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}

	public Set<Purchase> getPurchases() {
		return purchases;
	}

	public void setPurchases(Set<Purchase> purchases) {
		this.purchases = purchases;
	}

	public Set<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(Set<Rating> ratings) {
		this.ratings = ratings;
	}

	
	
	

}
