package com.example.model;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
	private String name;

	@NotBlank(message = "provide the temperature which is required to grow this flower.")
	private String temperature;

	private String imageUri;

	@NotBlank(message = "plant description cannot be null.")
	private String description;

	@NotNull(message = "plant stock cannot be null.")
	private Integer stock;

	@NotNull(message = "plant cost cannot be null.")
	private Double cost;

	private Integer discountedPrice;

	private Integer discountPercent;
	
	private Integer quantity;

	@NotBlank(message = "provide the difficulty level of growing.")
	private String difficultyLevel;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "order_product_table" , joinColumns =  {@JoinColumn(name = "product_id")} , inverseJoinColumns = {@JoinColumn(name = "order_id")})
	private List<Orders> orders;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<Review> reviews;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<Rating> ratings;
  
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime createdAt;

	@UpdateTimestamp
	@Column(insertable = false)
	private LocalDateTime lastModifiedDate;
	
	
}
