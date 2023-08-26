package com.example.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.dto.PlanterDto;
import com.example.model.Planter;
import com.example.service.PlanterServiceInterface;
import jakarta.validation.Valid;

@RestController
public class PlanterContorller {

	private PlanterServiceInterface planterServiceInterface;

	@Autowired
	public PlanterContorller(PlanterServiceInterface planterServiceInterface) {
		this.planterServiceInterface = planterServiceInterface;
	}

	@PostMapping("/planters/{userId}/{planterId}")
	public ResponseEntity<Planter> addPlanter(@PathVariable Integer userId, @PathVariable Integer planterId) {
		return new ResponseEntity<Planter>(planterServiceInterface.addPlanter(userId, planterId), HttpStatus.CREATED);
	}
	
	//admin should add the product..==========================================
	@PostMapping("/planters")
	public ResponseEntity<Planter> addPlanter(@Valid @RequestBody Planter planter) {
		return new ResponseEntity<Planter>(planterServiceInterface.addPlanter(planter), HttpStatus.CREATED);
	}

	@PutMapping("/planters")
	public ResponseEntity<Planter> updatePlanter(@RequestBody PlanterDto planter) {
		return new ResponseEntity<Planter>(planterServiceInterface.updatePlanter(planter), HttpStatus.CREATED);
	}
	///-----=========================================-========================

	@DeleteMapping("/planters/{planterId}")
	public ResponseEntity<String> deletePlaterById(@PathVariable Integer planterId) {
		return new ResponseEntity<String>(planterServiceInterface.deletePlanter(planterId), HttpStatus.OK);
	}

	@GetMapping("/planters/{planterId}")
	public ResponseEntity<Planter> viewPlanterById(@PathVariable Integer planterId) {
		return new ResponseEntity<Planter>(planterServiceInterface.viewPlanterById(planterId), HttpStatus.ACCEPTED);
	}

	@GetMapping("/planters")
	public ResponseEntity<List<Planter>> viewAllPlanter(
			@RequestParam(defaultValue = "0", required = false) Integer page,
			@RequestParam(defaultValue = "10", required = false) Integer size,
			@RequestParam(required = false) Map<String,String> map) {
		return new ResponseEntity<List<Planter>>(planterServiceInterface.viewAllPlanter(page,size,map), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/plantersBy/{shape}")
	public ResponseEntity<List<Planter>> ViewPlanterByPlanterShape(@PathVariable String shape){
		return new ResponseEntity<List<Planter>>(planterServiceInterface.ViewPlanterByPlanterShape(shape),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/planters/{min}/{max}")
	public ResponseEntity<List<Planter>> viewAllPlantersbetweenRange(@PathVariable Double min,@PathVariable Double max){
		return new ResponseEntity<List<Planter>>(planterServiceInterface.viewAllPlantersbetweenRange(min, max),HttpStatus.ACCEPTED);
	}
	
}