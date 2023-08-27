package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Orders;
import com.example.service.OrderServiceInteface;

@RestController
public class OrdersController {
	private OrderServiceInteface orderServiceInteface;

	@Autowired
	public OrdersController(OrderServiceInteface orderServiceInteface) {
		this.orderServiceInteface = orderServiceInteface;
	}

	@PostMapping("/orders/{userId}")
	public ResponseEntity<Orders> addOrdersFromCart(Integer userId){
		return new ResponseEntity<Orders>(orderServiceInteface.addOrdersFromCart(userId),HttpStatus.OK);
	}

	@PutMapping("/orders/{orderID}")
	public ResponseEntity<Orders> updateOrders(Integer orderID) {
		return new ResponseEntity<Orders>(orderServiceInteface.updateOrders(orderID),HttpStatus.OK);
	}

	@DeleteMapping("/orders/{orderId}")
	public ResponseEntity<Orders> deleteOrders(Integer orderId){
		return new ResponseEntity<Orders>(orderServiceInteface.deleteOrders(orderId),HttpStatus.OK);
	}

	@GetMapping("/orders/{orderId}")
	public ResponseEntity<Orders> viewOrder(Integer orderId){
		return new ResponseEntity<Orders>(orderServiceInteface.viewOrder(orderId),HttpStatus.OK);
	}

	@GetMapping("/allOrders/{userId}")
	public ResponseEntity<List<Orders>> viewAllOrders(Integer userId){
		return new ResponseEntity<List<Orders>>(orderServiceInteface.viewAllOrders(userId),HttpStatus.OK);
	}
}