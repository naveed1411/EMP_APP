package com.example.demo.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.responsestructure.ResponseStructure;
import com.example.demo.service.exceptionclasses.NoAddressFoundException;

@RestControllerAdvice
public class AddressExceptionHandler {

	@ExceptionHandler(NoAddressFoundException.class)
	public ResponseEntity<?> noAddressFoundExceptionHandler(NoAddressFoundException e)
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder().message("No Addresses  Found for the employee").status(HttpStatus.NOT_FOUND.value()).body(e.getMessage()).build());

	}
}
