package com.example.service;

import com.example.model.Cart;
import com.example.request.CartRequest;

public interface CartService {
	
	public Cart addPlanterInCart(CartRequest cartRequest);
	
	public Cart addproductIntoCart(CartRequest cartRequest);
	
	public Cart viewCart(Integer userId);
	
}
