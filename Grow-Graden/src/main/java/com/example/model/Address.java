package com.example.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@Data
@AllArgsConstructor
@EqualsAndHashCode
public class Address {
	private String city;
	private String district;
	private String state;
	private String pincode;
}
