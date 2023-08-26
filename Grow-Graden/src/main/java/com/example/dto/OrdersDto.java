package com.example.dto;

import java.time.LocalDate;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrdersDto {
	private Integer orderId;
	private LocalDate orderDate;
	private String transaction;
	private Map<Integer,Integer> prductsId;
	private Map<Integer,Integer> PlantersId;
}
