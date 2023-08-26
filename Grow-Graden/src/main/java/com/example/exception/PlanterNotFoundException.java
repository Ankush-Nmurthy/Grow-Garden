package com.example.exception;

public class PlanterNotFoundException extends RuntimeException{
	public PlanterNotFoundException(String msg) {
		super(msg);
	}
}
