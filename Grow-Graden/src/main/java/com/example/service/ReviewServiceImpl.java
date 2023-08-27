package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.exception.GlobalExceptionHandler;
import com.example.model.Review;
import com.example.repository.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review createReview(Review review) {
    	
    	if (review.getUser() == null || review.getProduct() == null || review.getDescription() == null) {
            throw new IllegalArgumentException("Invalid review details");
        }
    	
        return reviewRepository.save(review);
    }

    @Override
    public Optional<Review> getReviewById(Integer id) {
        return reviewRepository.findById(id);
    }
    
  
    @Override
    public List<Review> getReviewsByProductId(Integer productId) {

        return reviewRepository.findByProductProductId(productId);

    }

    @Override
    public List<Review> getReviewsByUserId(Integer userId) {
        return reviewRepository.findByUserId(userId);
    }

    
    @Override
    public String deleteReview(Integer id) {
        Optional<Review> optional = reviewRepository.findById(id);
        
       Review review = optional.orElseThrow(()-> new UsernameNotFoundException("Review Not found"));
       
       reviewRepository.delete(review);
       
       return "Review with ID" +id+ "deleted successfully";
    }
    
}

