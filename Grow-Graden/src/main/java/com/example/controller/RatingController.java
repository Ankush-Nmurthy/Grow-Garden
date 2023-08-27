package com.example.controller;

import com.example.model.Rating;
import com.example.model.Review;
import com.example.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RatingController {

	private RatingService ratingService;

	@Autowired
	public RatingController(RatingService ratingService) {
		this.ratingService = ratingService;
	}

	@PostMapping("/ratings")
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
		Rating createdRating = ratingService.createRating(rating);
		
		return new ResponseEntity<Rating>(createdRating, HttpStatus.CREATED);
        	      
    
	}

	@GetMapping("/ratings/{id}")
	public ResponseEntity<List<Rating>> getRatingById(@PathVariable Integer id) {
		Optional<Rating> rating = ratingService.getRatingById(id);
		
		if(rating.isPresent()) {
			  return new ResponseEntity<List<Rating>>((List<Rating>) rating.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }        
		
	}

	@GetMapping("/ratings/product/{productId}")
	public ResponseEntity<List<Rating>> getRatingsByProductId(@PathVariable Integer productId) {
		
		List<Rating> ratings = ratingService.getRatingsByProductId(productId);
	    
		return new ResponseEntity<List<Rating>>(ratings, HttpStatus.OK);
	  
	}

	@GetMapping("/ratings/user/{userId}")
	public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable Integer userId) {
		
		List<Rating> ratings = ratingService.getRatingsByUserId(userId);
        
		return new ResponseEntity<List<Rating>>(ratings, HttpStatus.OK);
    	
	}

}
