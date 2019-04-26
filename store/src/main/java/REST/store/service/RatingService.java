package REST.store.service;

import java.util.ArrayList;
import java.util.Set;

import REST.store.model.Item;
import REST.store.model.Rating;
import REST.store.persistence.PersistenceUtil;

public class RatingService {
	
	public RatingService() {
		
	}
	
	public Rating getRatingById(int id) {
		Rating rating = PersistenceUtil.findRatingById(id);
		return rating;
	}
	
	public void addRating(Rating rating) {
		PersistenceUtil.persist(rating);
	}
	
	public Set<Rating> findByItem(Item item) {
		Set<Rating> list = item.getRatings();
		return list;
	}

}
