package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.Rating;

public interface RatingService {
	Rating createRating(Rating rating);
    Optional<Rating> getRatingById(Integer id);
    List<Rating> getRatingsByProductId(Integer productId);
    List<Rating> getRatingsByUserId(Integer userId);
    String deleteRating(Integer id);
}
