package com.example.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.exception.ProductException;
import com.example.model.Product;
import com.example.repository.CategoryRepository;
import com.example.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;
	private CategoryRepository categoryRepository;
	private UserService userService;

	@Autowired
	public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository,
			UserService userService) {
		super();
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
		this.userService = userService;
	}

	@Override
	public Product createProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

	@Override
	public Product findProductById(Long id) throws ProductException {
		// TODO Auto-generated method stub
		Optional<Product> optional = productRepository.findById(id);
		Product product = optional.orElseThrow(() -> new ProductException("Product not found with id" + id));
		System.out.println(product);
		return product;
	}

	@Override
	public String deleteProductId(Long productId) throws ProductException {
		// TODO Auto-generated method stub
		Optional<Product> optional = productRepository.findById(productId);

		Product product = optional
				.orElseThrow(() -> new ProductException("Product with ID " + productId + " not found."));
		productRepository.delete(product);
		return "Product with ID " + productId + " deleted successfully.";
	}

	@Override
	public Product updateProduct(Long productId, Product requestProduct) throws ProductException {
		// TODO Auto-generated method stub
		Optional<Product> optional = productRepository.findById(productId);

		Product productPresent = optional
				.orElseThrow(() -> new ProductException("Product with ID " + productId + " not found."));

		if (productPresent.getQuantity() != 0)
			productPresent.setQuantity(requestProduct.getQuantity());

		return productRepository.save(productPresent);
	}

	@Override
	public List<Product> findProductByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Product> getAllProducts(String category, Integer minPrice, Integer maxPrice, Integer minDiscount,
			String sort, String stock, Integer pageNumber, Integer pageSize) {
		// TODO Auto-generated method stub

		Pageable pageable = PageRequest.of(pageNumber, pageSize);

		List<Product> products = productRepository.filterProducts(category, minPrice, maxPrice, minDiscount, sort);

		if (stock != null) {
			if (stock.equals("in_stock")) {
				products = products.stream().filter(p -> p.getQuantity() > 0).collect(Collectors.toList());
			} else if (stock.equals("out_of_stock")) {
				products = products.stream().filter(p -> p.getQuantity() < 1).collect(Collectors.toList());
			}
		}
		int startIndex = (int) pageable.getOffset();
		int endIndex = Math.min(startIndex + pageable.getPageSize(), products.size());
		List<Product> pageContent = products.subList(startIndex, endIndex);

		Page<Product> fileredProducts = new PageImpl<>(pageContent, pageable, products.size());
		return fileredProducts;
	}

	@Override
	public List<Product> allProdcuts() {
		// TODO Auto-generated method stub
		List<Product> products = productRepository.findAll();
		if (products.size() == 0)
			throw new ProductException("Product Not Found");
		return products;
	}

	@Override
	public List<Product> getAllPlants() throws ProductException {
		// TODO Auto-generated method stub
		List<Product> products = productRepository.getAllPlant();
		if (products.size() == 0)
			throw new ProductException("Plant Not Found");
		return products;
	}

	@Override
	public List<Product> getAllSeeds() throws ProductException {
		// TODO Auto-generated method stub
		List<Product> products = productRepository.getAllSeeds();
		if (products.size() == 0)
			throw new ProductException("Seed Not Found");
		return products;
	}

}
