package REST.store.model;

import java.util.Date;

public class Visa implements PaymentMethod {

	private final String name;
	private final String cardNumber;
	private final Date expires;
	
	public Visa(String name, String cardNumber, Date expires) {
		super();
		this.name = name;
		this.cardNumber = cardNumber;
		this.expires = expires;
	}

	@Override
	public boolean pay(double amount) {
		// TODO Auto-generated method stub
		return true;
	}
	
}
