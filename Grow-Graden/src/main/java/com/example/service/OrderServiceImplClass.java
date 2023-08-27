package com.example.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.exception.AdminException;
import com.example.exception.PlanterNotFoundException;
import com.example.exception.UserException;
import com.example.model.Orders;
import com.example.model.Planter;
import com.example.model.User;
import com.example.repository.CartRepository;
import com.example.repository.OrdersRepository;
import com.example.repository.PlanterRepository;
import com.example.repository.UserRepository;

public class OrderServiceImplClass implements OrderServiceInteface {

	private UserRepository userRepository;

	private PlanterRepository planterRepositoryInterface;

	private OrdersRepository ordersRepository;

	private CartRepository cartRepository;

	@Autowired
	public OrderServiceImplClass(PlanterRepository planterRepositoryInterface,
			OrdersRepository ordersRepository, UserRepository userRepository, CartRepository cartRepository) {
		this.planterRepositoryInterface = planterRepositoryInterface;
		this.ordersRepository = ordersRepository;
		this.userRepository = userRepository;
		this.cartRepository = cartRepository;
	}

	@Override
	public Orders addOrdersplanter(Integer userId, Orders orders) {
		return null;
	}

	@Override
	public Orders addOrdersproduct(Integer userId, Integer productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orders updateOrders(Integer orderId, Orders Orders) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orders deleteOrders(Integer orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orders viewOrder(Integer orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orders> viewAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}

}
