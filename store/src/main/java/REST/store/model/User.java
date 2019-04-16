package REST.store.model;

import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.jetty.util.security.Password;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private String payMethod;
	
	public User() {
		
	}
	
	public User(String name, String email, String password, String address, String payMethod) {
		//super();
		this.name=name;
		this.email=email;
		this.password=password;
		this.address=address;
		this.payMethod=payMethod;
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

	/*
	 * public Password getPassword() { return password; }
	 * 
	 * public void setPassword(Password password) { this.password = password; }
	 */
	
	

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

	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}
	
	

}
