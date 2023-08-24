package com.example.exception;

public class PlantNotFoundException extends Exception {

	public PlantNotFoundException() {

	}

	public PlantNotFoundException(String message) {
		super(message);
	}

}