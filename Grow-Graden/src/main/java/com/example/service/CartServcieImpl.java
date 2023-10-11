package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.exception.CartException;
import com.example.exception.PlanterNotFoundException;
import com.example.exception.ProductException;
import com.example.exception.UserException;
import com.example.model.Cart;
import com.example.model.Planter;
import com.example.model.Product;
import com.example.model.User;
import com.example.repository.CartRepository;
import com.example.repository.PlanterRepository;

import com.example.repository.ProductRepository;
import com.example.repository.UserRepository;
import com.example.request.CartRequest;

@Service
public class CartServcieImpl implements CartService {

	private CartRepository cartRepository;
	private ProductRepository productRepository;
	private PlanterRepository planterRepository;
	private UserRepository userRepository;

	public CartServcieImpl(CartRepository cartRepository, ProductRepository productRepository,
			PlanterRepository planterRepository, UserRepository userRepository) {
		super();
		this.cartRepository = cartRepository;
		this.productRepository = productRepository;
		this.planterRepository = planterRepository;
		this.userRepository = userRepository;
	}
	
	@Override
	public Cart addPlanterInCart(CartRequest cartRequest) {
		// TODO Auto-generated method stub
		Optional<User> userOpt = userRepository.findById(cartRequest.getUserId());
		User user = userOpt.orElseThrow(() -> new UserException("Invalid User Id " + cartRequest.getUserId()));

		Optional<Planter> planterOpt = planterRepository.findById(cartRequest.getProductId());

		Planter planter = planterOpt.orElseThrow(() -> new PlanterNotFoundException("Planter Not Found"));

		Double totalPrice = planter.getPlanterCost() * cartRequest.getQuantity();

		Cart cart = cartRepository.findByUserId(cartRequest.getUserId());

		if (cart == null)
			cart = new Cart();

		cart.getPlanterIds().add(planter.getPlanterId());
		cart.setQuantity(cart.getQuantity()+cartRequest.getQuantity());
		cart.setTotalPrice(totalPrice);
		cart.setUser(user);

		cartRepository.save(cart);

		return cart;
	}

	@Override
	public Cart addproductIntoCart(CartRequest cartRequest) {
		Optional<User> userOpt = userRepository.findById(cartRequest.getUserId());
		User user = userOpt.orElseThrow(() -> new UserException("Invalid User Id " + cartRequest.getUserId()));
		Optional<Product> producopt = productRepository.findById((long) cartRequest.getProductId());
		Product product = producopt.orElseThrow(() -> new ProductException("Product Not Found"));
		Double totalPrice = product.getCost() * cartRequest.getQuantity();
		Cart cart = cartRepository.findByUserId(cartRequest.getUserId());
		if (cart == null)
			cart = new Cart();
		cart.getProductIds().add(product.getProductId());
		cart.setQuantity(cart.getQuantity()+cartRequest.getQuantity());
		cart.setTotalPrice(totalPrice);
		cart.setUser(user);

		cartRepository.save(cart);
		return cart;
	}

	@Override
	public Cart viewCart(Integer userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new UserException("User not found for the given userId " + userId));
		if (user.getCart() == null) {
			throw new CartException("Cart of the User is empty please add some product.");
		}
		return user.getCart();
	}
}
