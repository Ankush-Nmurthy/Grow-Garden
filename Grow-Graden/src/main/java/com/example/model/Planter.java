package com.example.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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

	@NotNull(message = "provide a colour to planter")
	private String planterColour;

	@NotBlank(message = "please provide a image url of the given planter.")
	private String planterImageUrl;

	@NotBlank(message = "provide a valid shape to planter")
	private String planterShape;

	@NotNull(message = "planter stock cannot be null")
	private Integer planterStock;

	@NotNull(message = "provide a valid cost for the planter other than null.")
	private Double planterCost;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_Id")
	@JsonProperty(access = Access.WRITE_ONLY)
	private User user;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "order_planter_table", joinColumns = { @JoinColumn(name = "panter_id") }, inverseJoinColumns = {
			@JoinColumn(name = "order_id") })
	@JsonProperty(access = Access.WRITE_ONLY)
	private List<Orders> orders;

	@ManyToOne
	@JoinColumn(name = "cart_id")
	private Cart cart;
//	@ManyToOne
//	@JoinColumn(name = "user_Id")
//	@JsonProperty(access = Access.WRITE_ONLY)
//	private User user;

	/**
	 * { "planterHeight" : 15, "planterCapacity" : 20, "drinageHoles" : 30,
	 * "planterColour" : "Green", "planterShape" : "Round", "planterStock" : 50,
	 * "planterCost" : 300.00 }
	 */

}