package com.example.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("seed")
public class Seed extends Product{

	@NotBlank(message = "provide how much a seed should be watered.")
	private String watering; 
	
	@NotNull(message = "provide amount of seeds per pack.")
	private Integer seedsPerPack;
	
}
