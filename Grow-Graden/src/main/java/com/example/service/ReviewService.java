package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.Review;

public interface ReviewService {
	
	/**
	 * Creates a new review for the product.
	 * @param review
	 * @return Review
	 */
    Review createReview(Review review);
    
    /**
     * Gets a specific review using ReviewId.
     * @param id
     * @return Optional<Review>
     */
    Optional<Review> getReviewById(Integer id);
    
    /**
     * Gets reviews  of a particular products using product-id
     * @param productId
     * @return List<Review>
     */
    List<Review> getReviewsByProductId(Integer productId);
    
    /**
     * Gets reviews  of a particular products using userId-id
     * @param userId
     * @return List<Review>
     */
    List<Review> getReviewsByUserId(Integer userId);
    
    /**
     * Deletes a particular Review using review-id and returns it status. 
     * @param id
     * @return String
     */
    String deleteReview(Integer id);
}

