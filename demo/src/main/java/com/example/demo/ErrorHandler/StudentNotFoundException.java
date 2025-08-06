package com.example.demo.ErrorHandler;

public class StudentNotFoundException extends RuntimeException{

	public StudentNotFoundException(String message) {
		super(message);
	}
}
