package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.model.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer>{
	
}
