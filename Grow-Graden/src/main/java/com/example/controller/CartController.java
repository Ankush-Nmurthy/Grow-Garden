package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	private ResponseEntity<Cart> addPlantersToCart(@RequestBody CartRequest cartRequest){
		Cart cart =  cartService.addPlanterInCart(cartRequest);
		return new ResponseEntity<Cart>(cart,HttpStatus.OK);
	}

	@PostMapping("/products")
	private ResponseEntity<Cart> addProductsToCart(@RequestBody CartRequest cartRequest){
		Cart cart = cartService.addproductIntoCart(cartRequest);
		return new ResponseEntity<Cart>(cart,HttpStatus.OK);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<Cart> viewCartUsingUserId(@PathVariable Integer userId){
		return new ResponseEntity<Cart>(cartService.viewCart(userId),HttpStatus.OK);
	}
}
