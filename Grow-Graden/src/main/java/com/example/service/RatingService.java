package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.Rating;

public interface RatingService {
	
	/**
	 * Creates new Rating using.
	 * @param rating
	 * @return Rating
	 */
	Rating createRating(Rating rating);
	
	/**
	 * Gets a single raring by rating-Id
	 * @param id
	 * @return Optional<Rating>
	 */
    Optional<Rating> getRatingById(Integer id);
    
    /**
     * Gets all the rating for a particular product-Id
     * @param productId
     * @return List<Rating>
     */
    List<Rating> getRatingsByProductId(Integer productId);
    
    /**
     * Gets all the ratings that are done by a particular user using user-id.
     * @param userId
     * @return List<Rating>
     */
    List<Rating> getRatingsByUserId(Integer userId);
    
    /**
     * Delets a Rating using Rating-Id and returns the status of operation.
     * @param id
     * @return String
     */
    String deleteRating(Integer id);
}
