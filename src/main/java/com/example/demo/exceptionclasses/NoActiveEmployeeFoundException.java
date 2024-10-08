package com.example.demo.exceptionclasses;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NoActiveEmployeeFoundException extends RuntimeException {

	private String message;

//	public NoActiveEmployeeFoundException(String message) {
//		//super();
//		this.message = message;
//	}
//
//	public NoActiveEmployeeFoundException() {
//		super();
//	}
//	@Override
//	public String getMessage() {
//		// TODO Auto-generated method stub
//		return this.message;
//	}
	
}
