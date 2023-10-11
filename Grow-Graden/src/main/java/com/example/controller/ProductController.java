package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.ProductException;
import com.example.model.Product;
import com.example.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductService productService;

	// baseurl/api/products?category=ssds&
	@GetMapping("/products")
	public ResponseEntity<Page<Product>> findProductByCategory(@RequestParam String category,
			@RequestParam Integer minprice, @RequestParam Integer maxPrice, @RequestParam Integer minDiscount,
			@RequestParam String sort, @RequestParam String stock, @RequestParam String pageNumber,
			@RequestParam Integer pageSize) {

		Page<Product> res = productService.getAllProducts(category, minprice, maxPrice, minDiscount, sort, stock,
				minDiscount, pageSize);

		return new ResponseEntity<>(res, HttpStatus.ACCEPTED);

	}

	@GetMapping("/plants")
	public ResponseEntity<List<Product>> getAllPlant() {
		List<Product> products = productService.getAllPlants();
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

	@GetMapping("/seeds")
	public ResponseEntity<List<Product>> getAllSeed() {
		List<Product> products = productService.getAllSeeds();
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

	@GetMapping("/products/id/{productId}")
	public ResponseEntity<Product> findProductById(@PathVariable Long productId) {
		Product product = productService.findProductById(productId);
		return new ResponseEntity<Product>(product, HttpStatus.ACCEPTED);

	}

	@GetMapping("/products/{type}")
	public List<Product> getPlants(@PathVariable String type,
			@RequestParam(name = "sortField1", required = false) String sortField1,
			@RequestParam(name = "sortDirection1", required = false) String sortDirection1,
			@RequestParam(name = "sortField2", required = false) String sortField2,
			@RequestParam(name = "sortDirection2", required = false) String sortDirection2,
			@RequestParam(name = "sortField3", required = false) String sortField3,
			@RequestParam(name = "sortDirection3", required = false) String sortDirection3,
			@RequestParam(name = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(name = "pageSize", defaultValue = "10") int pageSize) {

		return productService.getPlantsWithSortingAndPagination(type, sortField1, sortDirection1, sortField2,
				sortDirection2, sortField3, sortDirection3, pageNo, pageSize);
	}

}
