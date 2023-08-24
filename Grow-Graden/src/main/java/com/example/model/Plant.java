package com.example.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@DiscriminatorValue("plant")
public class Plant extends Product{

	@NotNull(message = "plant height cannot be null.")
	private Integer plantHeight;
	
	@NotBlank(message = "provide the plants spread value.")
	private String plantSpread;
	
	private String medicinalOrCulinaryUse;

	@NotBlank(message = "provide the type of plant.")
	private String typeOfPlant;
	
	
}
