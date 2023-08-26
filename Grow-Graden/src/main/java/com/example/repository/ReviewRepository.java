package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
	
	/**
	    * 
	    * @param productId
	    * @return Rating of the product according to productId 
	    */
	List<Review> findByProductId(Integer productId);
    
	/**
	    * 
	    * @param userId
	    * @return Rating of the user according to userId 
	    */
	List<Review> findByUserId(Integer userId);

}

