package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Seed {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer seedID;
	
	@NotBlank(message = "provide a common name of the seed.")
	private String commonName;
	
	@NotBlank(message = "provide a bloom Timing of the seed.")
	private String bloomTime; 
	
	@NotBlank(message = "provide how much a seed should be watered.")
	private String watering; 
	
	@NotBlank(message = "provide growing difficultyLevel of the seed")
	private String difficultyLevel;
	
	@NotBlank(message = "provide growing temperature of the seed")
	private String temperature;
	
	@NotBlank(message = "provide which for type a seed belongs.")
	private String typeOfSeed;
	
	@NotBlank(message = "provide short desription abbout seed.")
	private String seedsDescription;
	
	@NotNull(message = "stocks cannot be null.")
	private Integer seedsStock;
	
	@NotNull(message = "seedsCost cannot be null.")
	private Double seedsCost;
	
	@NotNull(message = "provide amount of seeds per pack.")
	private Integer seedsPerPack;
	
	@ManyToOne
	@JoinColumn(name = "planter_id")
	private Planter planter;
}
