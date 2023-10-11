package com.example.service;

import com.example.model.Cart;
import com.example.request.CartRequest;

public interface CartService {
	
	/**
	 * addPlanterInCart(CartRequest cartRequest) method takes the CartRequest as the parameter
	 * and create a cart if the user adds the product to cart
	 * @param cartRequest
	 * @return Cart
	 */
	public Cart addPlanterInCart(CartRequest cartRequest);
	
	/**
	 * addproductIntoCart(CartRequest cartRequest) method takes the CartRequest as the parameter
	 * and create a cart if the user adds the product to cart
	 * @param cartRequest
	 * @return Cart
	 */
	public Cart addproductIntoCart(CartRequest cartRequest);
	
	/**
	 * viewCart(Integer userId) method takes the user-Id as the parameter and fetches the 
	 * user cart and return the cart
	 * @param cartRequest
	 * @return Cart
	 */
	public Cart viewCart(Integer userId);
	
}
