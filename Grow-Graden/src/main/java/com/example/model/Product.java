package com.example.model;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "product_type", discriminatorType = DiscriminatorType.STRING)
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;

	@NotBlank(message = "provide Common name of the plant.")
	private String commonName;

	@NotBlank(message = "provide the temperature which is required to grow this flower.")
	private String temperature;

	private String imageUri;

	@NotBlank(message = "plant description cannot be null.")
	private String description;

	@NotNull(message = "plant stock cannot be null.")
	private Integer stock;

	@NotNull(message = "plant cost cannot be null.")
	private Double cost;

	@NotBlank(message = "provide the difficulty level of growing.")
	private String difficultyLevel;

	//product should not have the relation b/w orders but it requires to have relation only with rating and review.
//	@OneToMany(mappedBy = "products",cascade = CascadeType.ALL)
//	private List<Orders> orders;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<Review> reviews;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<Rating> ratings;
	
	
	//only user needs product information but product in return does not need user information
	//One TO many byDirectional relation is not needed here.
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	//no need to have a bi-direction relation because any way user will be having the information of the 
		//products he had ordered.
}
