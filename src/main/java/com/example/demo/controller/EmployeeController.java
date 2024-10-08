package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.responsestructure.ResponseStructure;
import com.example.demo.service.EmployeeService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	 
	
	@PostMapping
	public ResponseEntity<?> saveEmployee(@RequestBody Employee employee)
	{
		return service.saveEmployee(employee);
	}
	                 
	 
  	@PutMapping
	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee)
	{
  		return service.updateEmployee(employee);
	}
  	
  	@GetMapping("/{id}")
  	public ResponseEntity<?> findEmployeeById(@PathVariable int  id)
  	{
  		return service.findEmployeeById(id);
  	}
  	@GetMapping
  	public ResponseEntity<?> findAllEmployee()
  	{
  		return service.findAllEmployee();
  	}

  	@GetMapping("/{email}/{password}")
  	public ResponseEntity<?> findEmployeeByEmailAndPassword(@PathVariable String email,@PathVariable String password)
  	{
  		return service.findEmployeeByEmailAndPassword(email, password);
  	}
  	
  	@GetMapping("/name/{name}")
  	public ResponseEntity<?> findEmployeeByName(@PathVariable String name)
  	{
  		return service.findEmployeeByName(name);		
  	}
  	
  	@DeleteMapping("/{id}")
  	public ResponseEntity<?> deleteEmployeeById(int id)
  	{
  		return service.deleteEmployeeById(id);
  	}
  	
  	@PatchMapping("/active/{id}")
  	public ResponseEntity<?> setEmployeeStatusToActive(@PathVariable int id)
  	{
  		
  		return service.setEmployeeStatusToActive(id);
  	}
  	
  	@PatchMapping("/inactive/{id}")
  	public ResponseEntity<?> setEmployeeStatusToInActive(@PathVariable int id)
  	{
  		
  		return service.setEmployeeStatusToInActive(id);
  	}
  	@PatchMapping("/allactive")
  	public ResponseEntity<?> setAllEmployeeActive()
  	{
  		return service.setAllEmployeeActive();
  	}
  	
  	
  	
}
