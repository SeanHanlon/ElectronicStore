package REST.store.model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class Visa implements PaymentMethod {

	private final String name;
	private final String cardNumber;
	private final String expires;
	
	public Visa(String name, String cardNumber, String expires) {
		super();
		this.name = name;
		this.cardNumber = cardNumber;
		this.expires = expires;
	}

	public String getName() {
		return name;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public String getExpires() {
		return expires;
	}

	@Override
	public boolean pay(double amount) {
		if(checkNumber(this.cardNumber) && this.checkDate(this.expires)) {
			return true;
		} 
		else {
			return false;
		}
	}

	@Override
	public boolean checkDate(String expiry) {
		ZoneId zoneId = ZoneId.of("GMT");
		LocalDate today = LocalDate.now(zoneId);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
		LocalDate expiryDate = LocalDate.parse(expiry, formatter);
		if (expiryDate.isBefore(today)) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public boolean checkNumber(String cardNumber) {
		if(cardNumber.length()!=16) {
			return false;
		}
		else {
			return true;
		}
	}

	
	
}
