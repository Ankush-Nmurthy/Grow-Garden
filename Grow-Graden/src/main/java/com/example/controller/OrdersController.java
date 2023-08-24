package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.model.Orders;
import com.example.service.OrdersServiceClass;
import jakarta.validation.Valid;

@RestController
public class OrdersController {

	private OrdersServiceClass ordersServiceClass;

	@Autowired
	public OrdersController(OrdersServiceClass ordersServiceClass) {
		this.ordersServiceClass = ordersServiceClass;
	}

	@PostMapping("/orders")
	public ResponseEntity<String> addOrders(@Valid @RequestBody Orders orders){
		System.out.println("hello");
		System.out.println(orders);
		return new ResponseEntity<>(ordersServiceClass.addorders(orders),HttpStatus.CREATED);
	}
}
