package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Plant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer plantId;
	
	@NotNull(message = "plant height cannot be null.")
	private Integer plantHeight;
	
	@NotBlank(message = "provide the plants spread value.")
	private String plantSpread;
	
	@NotBlank(message = "provide Common name of the plant.")
	private String commonName;
	
	@NotBlank(message = "provide the bloom time of the plant.")
	private String bloomTime; 
	
	private String medicinalOrCulinaryUse;
	
	@NotBlank(message = "provide the difficulty level of growing.")
	private String difficultyLevel;
	
	@NotBlank(message = "provide the temperature which is required to grow this flower.")
	private String temperature;
	
	@NotBlank(message = "provide the type of plant.")
	private String typeOfPlant;
	
	@NotBlank(message = "plant description cannot be null.")
	private String plantDescription;
	
	@NotNull(message = "plant stock cannot be null.")
	private Integer plantStock;
	
	@NotNull(message = "plant cost cannot be null.")
	private Double plantCost;
	
	@ManyToOne
	@JoinColumn(name = "planter_Id")
	private Planter planter;
	
}
