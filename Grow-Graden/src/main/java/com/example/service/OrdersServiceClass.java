package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.model.Orders;
import com.example.repository.OrdersRepositoryInterface;

@Service
public class OrdersServiceClass {
	
	private OrdersRepositoryInterface ordersRepositoryInterface;
	
	@Autowired
	public OrdersServiceClass(OrdersRepositoryInterface ordersRepositoryInterface) {
		this.ordersRepositoryInterface = ordersRepositoryInterface;
	}
	
	public String addorders(Orders ordes) {
		ordersRepositoryInterface.save(ordes);
		return "order added successfully.";
	}
	
}
