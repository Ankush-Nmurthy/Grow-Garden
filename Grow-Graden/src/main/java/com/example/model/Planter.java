package com.example.model;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Planter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer planterId;
	
	@NotNull(message = "plant height should not be null")
	private Float planterHeight;
	
	@NotNull(message = "planter Capacity should not be null")
	private Integer planterCapacity;
	
	@NotNull(message = "drinageHoles should not null and should have min one hole")
	@Min(1)
	private Integer drinageHoles;
	
	@NotNull(message = "provide a colur to planter")
	private Integer planterColour;
	
	@NotBlank(message = "provide a valid shape to planter")
	private String planterShape;
	
	@NotNull(message = "planter stock cannot be null")
	private Integer planterStock;
	
	@NotNull(message = "provide a valid cost for the planter other than null.")
	private Double planterCost;
	
	@OneToMany(mappedBy = "planter",cascade =  CascadeType.ALL)
	private List<Plant> plants;
	
	@OneToMany(mappedBy = "planter",cascade =  CascadeType.ALL)
	private List<Seed> seeds;
	
	@ManyToOne
	@JoinColumn(name = "user_Id")
	private User user;
}