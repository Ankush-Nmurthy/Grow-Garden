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

	/**
	 * findProductById() method finds the product by id takes Long Id as parameter.
	 * @param id
	 * @return Product
	 * @throws ProductException
	 */
	public Product findProductById(Long id) throws ProductException;

	/**
	 * 
	 * @param productId
	 * @return string value product delete or not
	 * @throws ProductException
	 */
	public String deleteProductId(Long productId) throws ProductException;

	/**updateProduct() updates the product of the given id.
	 * @param productId
	 * @param requestProduct
	 * @return String
	 * @throws ProductException
	 */
	public Product updateProduct(Long productId, Product requestProduct) throws ProductException;

	/**
	 * Finds the product by category.
	 * @param category
	 * @return List<Product>
	 */
	public List<Product> findProductByCategory(String category);

	/**
	 * Gets all the products that are register in the database.
	 * @return List<Product>
	 */
	public List<Product> allProdcuts();

	/**
	 * Gets all the products page wise. 
	 * @param category
	 * @param minPrice
	 * @param maxPrice
	 * @param minDiscount
	 * @param sort
	 * @param stock
	 * @param pageNumber
	 * @param  Page<Product> 
	 */
	public Page<Product> getAllProducts(String category, Integer minPrice, Integer maxPrice, Integer minDiscount,
			String sort, String stock, Integer pageNumber, Integer pageSize);

	/**
	 * Gets all the plants that are present in the database.
	 * @return List<Product> 
	 * @throws ProductException
	 */
	public List<Product> getAllPlants() throws ProductException;

	/**
	 * Gets all the Seeds that are present in the database.
	 * @return List<Product>
	 * @throws ProductException
	 */
	public List<Product> getAllSeeds() throws ProductException;

	// ---------Ankuh- ------------;
	/**
	 * Gets Plants by Sorting them also uses Pagination
	 * @param producttype
	 * @param sortField1
	 * @param sortDirection1
	 * @param sortField2
	 * @param sortDirection2
	 * @param sortField3
	 * @param sortDirection3
	 * @param pageNo
	 * @param pageSize
	 * @return List<Product>
	 */
	public List<Product> getPlantsWithSortingAndPagination(String producttype, String sortField1, String sortDirection1,
			String sortField2, String sortDirection2, String sortField3, String sortDirection3, int pageNo,
			int pageSize);

}
