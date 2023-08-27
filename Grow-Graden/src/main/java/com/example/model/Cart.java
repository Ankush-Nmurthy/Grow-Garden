package com.example.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cartId;
	
	private Double totalPrice;
	
	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
	private List<Product> products = new ArrayList<>();
	
	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
	private List<Planter> planters = new ArrayList<>();
	
	private Integer userid;
	
}
