package com.example.demo.exceptionclasses;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class NoAddressesFoundException extends RuntimeException{

	private String message;
}
