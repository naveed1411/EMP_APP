package com.example.demo.service.exceptionclasses;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NoEmployeeFoundException extends RuntimeException {

	
	
	private String message;
//
//	public NoEmployeeFoundException(String msg) {
//		//super();
//		this.msg = msg;
//	}
//
//	public NoEmployeeFoundException() {
//		super();
//	}
//	@Override
//	public String getMessage() {
//		// TODO Auto-generated method stub
//		return this.msg;
//	}

	
	
}
