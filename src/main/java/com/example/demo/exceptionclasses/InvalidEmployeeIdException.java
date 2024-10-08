package com.example.demo.exceptionclasses;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InvalidEmployeeIdException extends RuntimeException {

	
	private String message;

//	public InvalidEmployeeIdException(String message) {
//		//super();
//		this.message = message;
//	}
//
//	public InvalidEmployeeIdException() {
//		super();
//	}
//	@Override
//	public String getMessage() {
//		// TODO Auto-generated method stub
//		return this.message;
//	}
	
}
