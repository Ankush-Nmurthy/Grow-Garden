package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanterDto {
	private Integer planterId;
	private Float planterHeight;
	private Integer planterCapacity;
	private Integer drinageHoles;
	private String planterColour;
	private String planterShape;
	private Integer planterStock;
	private Double planterCost;
	private String planterImageUrl;
}
