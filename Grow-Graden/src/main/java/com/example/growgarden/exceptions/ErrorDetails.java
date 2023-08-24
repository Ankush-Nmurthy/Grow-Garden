package com.masai.exceptions;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorDetails {

	private final LocalDateTime timestamp=LocalDateTime.now();
	private String message;
	private String Details;
	
	
}