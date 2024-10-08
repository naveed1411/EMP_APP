package com.example.demo.exceptionclasses;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InvalidCredentialsException extends RuntimeException {
	
	
	private String message;

//	public InvalidCredentialsException(String message) {
//		//super();
//		this.message = message;
//	}
//
//	public InvalidCredentialsException() {
//		super();
//	}
//	@Override
//	public String getMessage() {
//		// TODO Auto-generated method stub
//		return this.message;
//	}
	

}
