package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
 	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user; 
	
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
}
