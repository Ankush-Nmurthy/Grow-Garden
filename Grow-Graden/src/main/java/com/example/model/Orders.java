package com.example.model;

import java.time.LocalDate;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookingOrderId;

	@FutureOrPresent(message = "Order date must be Futuer or present")
	private LocalDate orderDate;

	@NotBlank(message = "please provide transaction type.")
	private String transaction;

	@NotNull(message = "quantity should be minimum - 1")
	@Min(1)
	private Integer quantity;

	@NotNull(message = "cost cannot be null.")
	private Double totalCost;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Planter> planters;

}
