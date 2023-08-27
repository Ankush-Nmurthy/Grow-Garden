package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.dto.PlanterDto;
import com.example.exception.CartException;
import com.example.exception.PlantNotFoundException;
import com.example.exception.PlanterNotFoundException;
import com.example.model.Cart;
import com.example.model.Planter;
import com.example.model.User;
import com.example.repository.CartRepository;
import com.example.repository.PlanterRepositoryInterface;
import com.example.repository.UserRepository;

@Service
public class PlanterServiceImplClass implements PlanterServiceInterface {

	private PlanterRepositoryInterface planterRepositoryInterface;

	private UserRepository userRepository;

	private CartRepository cartRepository;

	@Autowired
	public PlanterServiceImplClass(PlanterRepositoryInterface planterRepositoryInterface, UserRepository userRepository,
			CartRepository cartRepository) {
		this.planterRepositoryInterface = planterRepositoryInterface;
		this.userRepository = userRepository;
		this.cartRepository = cartRepository;
	}

	// this Adds the planter to a user.
	// I have changed the Users List<Planter> property to only write because
	// was causing Infinite calls form user side .
	@Override
	public Cart addPlanter(Integer userId, Integer planterId, Integer quantity) {
		User user = userRepository.findById(userId).orElseThrow(() -> new UsernameNotFoundException("No User found for the given userId : "+userId));
		Planter planter = planterRepositoryInterface.findById(planterId).orElseThrow(() -> new PlanterNotFoundException("Planter not found for the given planter Id : "+planterId));
		Cart cart = null;
		if(user.getCart() == null) {
			cart = new Cart();
			user.setCart(cart);
			cart.getPlanters().add(planter);
		}
		else {
			cart = cartRepository.findById(user.getCart().getCartId()).get();
			cart.getPlanters().add(planter);
		}
		// fetching the price of existing cart inside the user and if 
		// the value is null setting the value to 0;
		double cartPrice;
		if(cart.getTotalPrice() == null) { 
			cartPrice = 0;
		}
		else {
			cartPrice = cart.getTotalPrice();
		}
		
		// adding the total amount for the quantity for the user cart. 
		for(Planter plant : cart.getPlanters()) {
			double price = plant.getPlanterCost()*quantity;
			cartPrice += price;
		}
		
		planter.setPlanterStock(planter.getPlanterStock() - quantity);
		cart.setTotalPrice(cartPrice);
		cart.setUserid(user.getId());// setting the user to cart and cart to user.
		user.setCart(cart);
		planter.setCart(cart);
		cartRepository.save(cart);
		userRepository.save(user);
		planterRepositoryInterface.save(planter);
		return cart;
	}

	@Override
	public Planter addPlanter(Planter planter) {
		if (planter == null) {
			throw new PlanterNotFoundException("Provide a valid planter Details.");
		}
		return planterRepositoryInterface.save(planter);
	}

	@Override
	public Planter updatePlanter(PlanterDto inputplanter) {
		if (inputplanter.getPlanterId() == null) {
			throw new PlanterNotFoundException("Please provide a planter Id while sending the request");
		}
		Planter planterDb = planterRepositoryInterface.findById(inputplanter.getPlanterId())
				.orElseThrow(() -> new PlanterNotFoundException(
						"No planter found for the given planter Id : " + inputplanter.getPlanterId()));
		System.out.println(planterDb);
		if (inputplanter.getDrinageHoles() != null)
			planterDb.setDrinageHoles(inputplanter.getDrinageHoles());
		if (inputplanter.getPlanterCapacity() != null)
			planterDb.setPlanterCapacity(inputplanter.getPlanterCapacity());
		if (inputplanter.getPlanterColour() != null)
			planterDb.setPlanterColour(inputplanter.getPlanterColour());
		if (inputplanter.getPlanterCost() != null)
			planterDb.setPlanterCost(inputplanter.getPlanterCost());
		if (inputplanter.getPlanterHeight() != null)
			planterDb.setPlanterHeight(inputplanter.getPlanterHeight());
		if (inputplanter.getPlanterShape() != null)
			planterDb.setPlanterShape(inputplanter.getPlanterShape());
		if (inputplanter.getPlanterStock() != null)
			planterDb.setPlanterStock(inputplanter.getPlanterStock());
		if (inputplanter.getPlanterImageUrl() != null)
			planterDb.setPlanterImageUrl(inputplanter.getPlanterImageUrl());
		return planterRepositoryInterface.save(planterDb);
	}

	@Override
	public String deletePlanter(Integer planterId) {
		Planter planter = planterRepositoryInterface.findById(planterId).orElseThrow(
				() -> new PlanterNotFoundException("No planter found for the given Planter-Id : " + planterId));
		planterRepositoryInterface.delete(planter);
		return "Planter deleted Successfully.";
	}

	@Override
	public Planter viewPlanterById(Integer planterId) {
		Planter planter = planterRepositoryInterface.findById(planterId).orElseThrow(
				() -> new PlanterNotFoundException("No planter found for the given Planter-Id : " + planterId));
		return planter;

	}

	@Override
	public List<Planter> viewAllPlanter(Integer pageno, Integer size, Map<String, String> sortmap) {
		List<Sort.Order> sortedList = new ArrayList<>();
		for (Map.Entry<String, String> entry : sortmap.entrySet()) {
			if (entry.getKey().equals("page") || entry.getKey().equals("size")) {
				continue;
			} else {
				String feildname = entry.getKey();
				String direction = entry.getValue();
				Sort.Direction sortDirection = "desc".equalsIgnoreCase(direction) ? Sort.Direction.DESC
						: Sort.Direction.ASC;
				// creating the new Sorting List by using the key and value in the map.
				sortedList.add(new Sort.Order(sortDirection, feildname));
			}
		}
		// creating the Sort for the paging;
		// System.out.println(sortedList);
		Sort sort = Sort.by(sortedList);
		Pageable page = PageRequest.of(pageno, size, sort);
		Page<Planter> newPage = planterRepositoryInterface.findAll(page);
		if (!newPage.hasContent()) {
			throw new PlanterNotFoundException("No planter found for a given page : " + pageno);
		}
		return newPage.getContent();
	}

	@Override
	public List<Planter> ViewPlanterByPlanterShape(String shape) {
		if (shape == null) {
			throw new PlanterNotFoundException("Please provide the properShape inorder to view planter By shape");
		}
		return planterRepositoryInterface.findByPlanterShape(shape);
	}

	@Override
	public List<Planter> viewAllPlantersbetweenRange(double min, double max) {
		if (min > max) {
			throw new PlantNotFoundException("minimum price should be less the maximum");
		}
		return planterRepositoryInterface.findByplanterCostBetween(min, max);
	}

}
