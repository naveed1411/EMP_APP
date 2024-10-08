package com.example.demo.exceptionhandler;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exceptionclasses.InvalidCredentialsException;
import com.example.demo.exceptionclasses.InvalidEmployeeIdException;
import com.example.demo.exceptionclasses.NoActiveEmployeeFoundException;
import com.example.demo.responsestructure.ResponseStructure;
import com.example.demo.service.exceptionclasses.NoEmployeeFoundException;

@RestControllerAdvice
public class EmployeeExceptionHandler {
	
	@ExceptionHandler(NoActiveEmployeeFoundException.class)
	public ResponseEntity<?> noActiveEmployeeFoundExceptionHandler(NoActiveEmployeeFoundException e)
	{
		return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder().status(HttpStatus.NOT_FOUND.value()).body(e.getMessage()).message("no active employeee found in the database.....").build());
	}
	
	@ExceptionHandler(InvalidEmployeeIdException.class)
	public ResponseEntity<?> invalidEmployeeIdExceptionHandler(InvalidEmployeeIdException e)
	{
		
		
		return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder().status(HttpStatus.NOT_FOUND.value()).body(e.getMessage()).message("no  employeee with the id  found in the database.....").build());
	}
	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<?> invalidCredentialsExceptionHandler(InvalidCredentialsException e)
	{
		return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder().status(HttpStatus.NOT_FOUND.value()).body(e.getMessage()).message("Invalid Email and Password ..").build());
	}
	
	
	@ExceptionHandler(NoEmployeeFoundException.class)
	public ResponseEntity<?> noEmployeeFoundExceptionHandler(NoEmployeeFoundException e)
	{
	
		return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder().status(HttpStatus.NOT_FOUND.value()).body(e.getMessage()).message("No Employee with the requested name ..").build());

	}
	
	
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<?> sQLIntegrityConstraintViolationExceptionHandler(SQLIntegrityConstraintViolationException e)
	{
	
		return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseStructure.builder().status(HttpStatus.BAD_REQUEST.value()).body(e.getMessage()).message("Duplicate Entry - the value  should be unique").build());

	}
	

}
