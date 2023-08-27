package com.example.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.model.Orders;
import com.example.model.User;

public interface OrdersRepository extends JpaRepository<Orders, Integer>{
	List<Orders> findByUser(User user);
}
