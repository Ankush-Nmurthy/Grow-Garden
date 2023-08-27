package com.example.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.exception.ProductException;
import com.example.model.Plant;
import com.example.model.Product;

public interface ProductService {

	/**
	 * This method for create new product
	 * 
	 * @param productRequest
	 * @return product
	 */
	public Product createProduct(Product product);

	public Product findProductById(Long id) throws ProductException;

	/**
	 * 
	 * @param productId
	 * @return string value product delete or not
	 * @throws ProductException
	 */
	public String deleteProductId(Long productId) throws ProductException;

	public Product updateProduct(Long productId, Product requestProduct) throws ProductException;

	public List<Product> findProductByCategory(String category);

	public List<Product> allProdcuts();

	public Page<Product> getAllProducts(String category, Integer minPrice, Integer maxPrice, Integer minDiscount,
			String sort, String stock, Integer pageNumber, Integer pageSize);

	public List<Product> getAllPlants() throws ProductException;

	public List<Product> getAllSeeds() throws ProductException;

	// ---------Ankuh- ------------;
	public List<Product> getPlantsWithSortingAndPagination(String producttype, String sortField1, String sortDirection1,
			String sortField2, String sortDirection2, String sortField3, String sortDirection3, int pageNo,
			int pageSize);

}
