package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Cart;
import com.example.request.CartRequest;
import com.example.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	private CartService cartService;
	
	
	
	public CartController(CartService cartService) {
		super();
		this.cartService = cartService;
	}


	@PostMapping("/planter")
	private ResponseEntity<Cart> addPlanterInCart(@RequestBody CartRequest cartRequest){
		Cart cart =  cartService.addPlanterInCart(cartRequest);
		return new ResponseEntity<Cart>(cart,HttpStatus.OK);
	}

}
