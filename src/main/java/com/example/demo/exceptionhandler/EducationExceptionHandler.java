package com.example.demo.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exceptionclasses.NoEducationFoundException;
import com.example.demo.responsestructure.ResponseStructure;

@RestControllerAdvice
public class EducationExceptionHandler {

	@ExceptionHandler(NoEducationFoundException.class)
	public ResponseEntity<?> noEducationFoundExceptionHandler(NoEducationFoundException e)
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder().message("No Education Found for the employee").status(HttpStatus.NOT_FOUND.value()).body(e.getMessage()).build());
		
	}
}
