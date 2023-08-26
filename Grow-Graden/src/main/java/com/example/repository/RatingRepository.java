package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {
   /**
    * 
    * @param productId
    * @return Rating of the product according to productId 
    */
	List<Rating> findByProductId(Integer productId);
	
	/**
	    * 
	    * @param userId
	    * @return Rating of the user according to userId 
	    */
	List<Rating> findByUserId(Integer userId);
    
}

