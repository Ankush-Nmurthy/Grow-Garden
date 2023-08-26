package com.example.model;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
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


	@NotBlank(message = "provide the type of plant.")
	private String typeOfPlant;
	
	
}
