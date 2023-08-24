package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.model.Orders;

@Repository
public interface OrdersRepositoryInterface extends JpaRepository<Orders, Integer>{

}
