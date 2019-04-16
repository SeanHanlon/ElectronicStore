package REST.store.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

@NamedQueries( {
	@NamedQuery(name = "Item.findAllItems", query = "select o from Item o"),
	@NamedQuery(name = "Item.findByCategory", query = "select o from Item o where o.category like concat('%', :category, '%') "),
	@NamedQuery(name = "Item.findByManufacturer", query = "select o from Item o where o.manufacturer=:manufacturer "),
	@NamedQuery(name = "Item.findByTitle", query = "select o from Item o where o.title like concat('%', :title, '%') ")
})

@XmlRootElement
@Entity
public class Item {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String title;
	private String manufacturer;
	private double price;
	private String category;
	private int stockLevel;
	
	public Item() {
		
	}
	
	public Item(String title, String manufacturer, double price, String category, int stockLevel) {
		this.title=title;
		this.manufacturer=manufacturer;
		this.price=price;
		this.category=category;
		this.stockLevel=stockLevel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getStockLevel() {
		return stockLevel;
	}

	public void setStockLevel(int stockLevel) {
		this.stockLevel = stockLevel;
	}
	
	
	
}
