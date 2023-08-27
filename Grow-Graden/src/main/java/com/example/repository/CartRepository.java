package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {
	
}
