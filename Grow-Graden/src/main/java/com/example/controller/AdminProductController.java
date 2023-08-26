package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Plant;
import com.example.model.Product;
import com.example.model.Seed;
import com.example.responce.ApiResponse;
import com.example.service.ProductService;
import com.example.service.UserService;

@RestController
@RequestMapping("api/admin/products")
public class AdminProductController {
	

	private ProductService productService;
	private UserService userService;
	
	
	@Autowired
	public AdminProductController(ProductService productService, UserService userService) {
		super();
		this.productService = productService;
		this.userService = userService;
	}

	@PostMapping("/plant")
	public ResponseEntity<Product> createPlant(@RequestBody Product plant){
		System.out.println(plant);
		return new ResponseEntity<Product>(productService.createProduct(plant),HttpStatus.CREATED);
	}
	
	@PostMapping("/seed")
	public ResponseEntity<Product> createSeed(@RequestBody Product seed){
		return new ResponseEntity<Product>(productService.createProduct(seed),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{product}/delete")
	public ResponseEntity<ApiResponse> deleteProduct(@PathVariable Long productId){
		ApiResponse apiResponse = new ApiResponse(productService.deleteProductId(productId), true);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Product>> findAllProducts(){
		List<Product> products = productService.allProdcuts();
		return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
	}
	
	@GetMapping("/plants")
	public ResponseEntity<List<Product>> getAllPlant(){
		List<Product> products = productService.getAllPlants();
		return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
	}
	
	@GetMapping("/seeds")
	public ResponseEntity<List<Product>> getAllSeed(){
		List<Product> products = productService.getAllSeeds();
		return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
	}
	 

}
