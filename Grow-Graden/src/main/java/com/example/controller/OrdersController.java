package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Cart;
import com.example.model.Orders;
import com.example.service.OrderServiceInteface;

@RestController
@RequestMapping("/orders")
public class OrdersController {
	
	private OrderServiceInteface orderServiceInteface;

	@Autowired
	public OrdersController(OrderServiceInteface orderServiceInteface) {
		this.orderServiceInteface = orderServiceInteface;
	}

	@PostMapping("/{userId}")
	public ResponseEntity<Cart> addOrdersFromCart(@PathVariable Integer userId){
		return new ResponseEntity<Cart>(orderServiceInteface.addOrdersFromCart(userId),HttpStatus.OK);
	}

	@PutMapping("/{orderID}")
	public ResponseEntity<Orders> updateOrders(@PathVariable Integer orderID) {
		return new ResponseEntity<Orders>(orderServiceInteface.updateOrders(orderID),HttpStatus.OK);
	}

	@DeleteMapping("/{orderId}")
	public ResponseEntity<Orders> deleteOrders(@PathVariable Integer orderId){
		return new ResponseEntity<Orders>(orderServiceInteface.deleteOrders(orderId),HttpStatus.OK);
	}

	@GetMapping("/{orderId}")
	public ResponseEntity<Orders> viewOrder(@PathVariable Integer orderId){
		return new ResponseEntity<Orders>(orderServiceInteface.viewOrder(orderId),HttpStatus.OK);
	}

	@GetMapping("/allOrders/{userId}")
	public ResponseEntity<List<Orders>> viewAllOrders(@PathVariable Integer userId){
		return new ResponseEntity<List<Orders>>(orderServiceInteface.viewAllOrders(userId),HttpStatus.OK);
	}
}
