package com.example.service;

import com.example.model.Rating;
import com.example.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepository;

    @Autowired
    public RatingServiceImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public Rating createRating(Rating rating) {
    	if (rating.getUser() == null || rating.getProduct() == null || rating.getRating() == null) {
            throw new IllegalArgumentException("Invalid rating details");
        }

        return ratingRepository.save(rating);
    }

    @Override
    public Optional<Rating> getRatingById(Integer id) {
        return ratingRepository.findById(id);
    }

    @Override
    public List<Rating> getRatingsByProductId(Integer productId) {
        return ratingRepository.findByProductId(productId);
    }

    @Override
    public List<Rating> getRatingsByUserId(Integer userId) {
        return ratingRepository.findByUserId(userId);
    }

    
    @Override
    public String deleteRating(Integer id) {
        Optional<Rating> optional = ratingRepository.findById(id);
        
       Rating rating = optional.orElseThrow(()-> new UsernameNotFoundException("Review Not found"));
       
       ratingRepository.delete(rating);
       
       return "Rating with ID" +id+ "deleted successfully";
    }
    
}

