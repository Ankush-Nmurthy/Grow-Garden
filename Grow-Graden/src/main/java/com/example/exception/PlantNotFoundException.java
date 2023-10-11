package com.example.exception;

public class PlantNotFoundException extends RuntimeException {

	public PlantNotFoundException(String message) {
		super(message);
	}

}