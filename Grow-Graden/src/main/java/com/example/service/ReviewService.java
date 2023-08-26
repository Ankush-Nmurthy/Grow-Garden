package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.Review;

public interface ReviewService {
    Review createReview(Review review);
    Optional<Review> getReviewById(Integer id);
    List<Review> getReviewsByProductId(Integer productId);
    List<Review> getReviewsByUserId(Integer userId);
    
}

