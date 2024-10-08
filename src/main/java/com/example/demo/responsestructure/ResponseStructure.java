package com.example.demo.responsestructure;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseStructure<T> {
	
	
	private int status;
	private String message;
	private  T body;

}
