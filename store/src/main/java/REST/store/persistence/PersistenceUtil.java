package REST.store.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import REST.store.model.Admin;
import REST.store.model.CartItems;
import REST.store.model.Item;
import REST.store.model.Purchase;
import REST.store.model.ShoppingCart;
import REST.store.model.User;

  
public class PersistenceUtil implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("electronicstore");
	
	public static void persist(Object entity) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
		em.close();
	}

	public static void remove(Object entity) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Object mergedEntity = em.merge(entity);
		em.remove(mergedEntity);
		em.getTransaction().commit();
		em.close();
	}
	
	public static Object merge(Object entity) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		entity = em.merge(entity);
		em.getTransaction().commit();		
		em.close();
		return entity;
	}

	public static EntityManager createEM() {
		return emf.createEntityManager();
	}
	
	public static List<User> findAllUsers(){
		EntityManager em = emf.createEntityManager();
		List<User> users = (List<User>) em.createNamedQuery("User.findAllUsers").getResultList();
		em.close();
		return users;
	}
	
	public static List<Item> findAllItems(){
		EntityManager em = emf.createEntityManager();
		List<Item> items = (List<Item>) em.createNamedQuery("Item.findAllItems").getResultList();
		em.close();
		return items;
	}
	
	public static List<Admin> findAllAdmins(){
		EntityManager em = emf.createEntityManager();
		List<Admin> admins = (List<Admin>) em.createNamedQuery("Admin.findAllAdmins").getResultList();
		em.close();
		return admins;
	}
	
	public static List<Purchase> findAllPurchases(){
		EntityManager em = emf.createEntityManager();
		List<Purchase> purchases = (List<Purchase>) em.createNamedQuery("Purchase.findAll").getResultList();
		em.close();
		return purchases;
	}

	public static User findUserByName(String name){
		EntityManager em = emf.createEntityManager();
		List<User> users = (List<User>) em.createNamedQuery("User.findByName").setParameter("name", name).getResultList();
		em.close();
		if (users.size() == 0)
			return null;
		else 
			return users.get(0);
	}
	
	public static User findUserByEmail(String email){
		EntityManager em = emf.createEntityManager();
		List<User> users = (List<User>) em.createNamedQuery("User.findByEmail").setParameter("email", email).getResultList();
		em.close();
		if (users.size() == 0)
			return null;
		else 
			return users.get(0);
	}
	
	public static User findUserById(int id){
		EntityManager em = emf.createEntityManager();
		List<User> users = (List<User>) em.createNamedQuery("User.findById").setParameter("id", id).getResultList();
		em.close();
		if (users.size() == 0)
			return null;
		else 
			return users.get(0);
	}
	
	public static Item findItemById(int id){
		EntityManager em = emf.createEntityManager();
		List<Item> items = (List<Item>) em.createNamedQuery("Item.findById").setParameter("id", id).getResultList();
		em.close();
		if (items.size() == 0)
			return null;
		else 
			return items.get(0);
	}
	
	public static Purchase findPurchaseById(int id){
		EntityManager em = emf.createEntityManager();
		List<Purchase> items = (List<Purchase>) em.createNamedQuery("Purchase.findById").setParameter("id", id).getResultList();
		em.close();
		if (items.size() == 0)
			return null;
		else 
			return items.get(0);
	}
	
	public static ShoppingCart findCartById(int id){
		EntityManager em = emf.createEntityManager();
		List<ShoppingCart> carts = (List<ShoppingCart>) em.createNamedQuery("Cart.findById").setParameter("id", id).getResultList();
		em.close();
		if (carts.size() == 0)
			return null;
		else 
			return carts.get(0);
	}
	
	public static List<CartItems> findByCartId(int id){
		EntityManager em = emf.createEntityManager();
		List<CartItems> carts = (List<CartItems>) em.createNamedQuery("CartItems.findById").setParameter("id", id).getResultList();
		em.close();
		if (carts.size() == 0)
			return null;
		else 
			return carts;
	}
	
	public static List<Item> findItemByCategory(String category){
		EntityManager em = emf.createEntityManager();
		List<Item> items = (List<Item>) em.createNamedQuery("Item.findByCategory").setParameter("category", category).getResultList();
		em.close();
		if (items.size() == 0)
			return null;
		else 
			return items;
	}
	
	public static List<Item> findItemByManu(String manufacturer){
		EntityManager em = emf.createEntityManager();
		List<Item> items = (List<Item>) em.createNamedQuery("Item.findByManufacturer").setParameter("manufacturer", manufacturer).getResultList();
		em.close();
		if (items.size() == 0)
			return null;
		else 
			return items;
	}
	
	public static List<Item> findItemByTitle(String title){
		EntityManager em = emf.createEntityManager();
		List<Item> items = (List<Item>) em.createNamedQuery("Item.findByTitle").setParameter("title", title).getResultList();
		em.close();
		if (items.size() == 0)
			return null;
		else 
			return items;
	}
	
	
}

