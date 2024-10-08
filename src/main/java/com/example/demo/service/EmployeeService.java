package com.example.demo.service;

//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.example.demo.dao.EmployeeDao;

import com.example.demo.entity.Employee;
import com.example.demo.exceptionclasses.InvalidCredentialsException;
import com.example.demo.exceptionclasses.InvalidEmployeeIdException;
import com.example.demo.exceptionclasses.NoActiveEmployeeFoundException;
import com.example.demo.responsestructure.ResponseStructure;
import com.example.demo.service.exceptionclasses.NoEmployeeFoundException;
import com.example.demo.util.EmployeeStatus;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao dao;
	
	
	
	public ResponseEntity<?> saveEmployee(Employee employee)
	{
		employee.setStatus(com.example.demo.util.EmployeeStatus.IN_ACTIVE);
		 employee = dao.saveEmployee(employee);
		return ResponseEntity.status(HttpStatus.CREATED).body(ResponseStructure.builder().body(employee).message("Employee Created successfully...").status(HttpStatus.CREATED.value()).build());

	}
	
	public ResponseEntity<?> updateEmployee(Employee employee)
	{
		 employee = dao.updateEmployee(employee);
		
		//return new ResponseEntity(ResponseStructure.builder().body(employee).message("Employee Updated successfully...").status(HttpStatus.OK.value()).build(),HttpStatus.OK);
	return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().body(employee).message("Employee Updated successfully...").status(HttpStatus.OK.value()).build());
	}
	public ResponseEntity<?>  findEmployeeById(int id)
	{
		Optional<Employee> op=dao.findEmployeeById(id);

		if(op.isEmpty())
		{
			throw InvalidEmployeeIdException.builder().message("Invalid ID ... No Employee Found with the specified id....").build();
		}
		//return new ResponseEntity(ResponseStructure.builder().body(op.get()).message("Employee Updated successfully...").status(HttpStatus.OK.value()).build(),HttpStatus.OK);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().body(op.get()).message("Employee Updated successfully...").status(HttpStatus.OK.value()).build());
		
	}
	
	public ResponseEntity<?> findAllEmployee()
	{
		List<Employee> employees=dao.findAllActiveEmployee();
		
		if(employees.isEmpty())
		{
			throw  NoActiveEmployeeFoundException.builder().message("No Active Employees Found ...").build();
			
		}
//		List<Employee> activeEmployees=new ArrayList<>();
//		for(Employee e:employees)
//		{
//			if(e.getStatus()==EmployeeStatus.ACTIVE)
//				activeEmployees.add(e);
//		}
		//structure.setBody(activeEmployees);
//		structure.setBody(employees);
//		structure.setStatus(HttpStatus.OK.value());
//		structure.setMessage("all employees found successfully.....");
//		return structure;
		
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().body(employees).status(HttpStatus.OK.value()).message("all employees found successfully.....").build());                                                    
		
		
	}
	public ResponseEntity<?> findEmployeeByEmailAndPassword(String email,String password)
	{
		Optional<Employee> op=dao.findEmployeeByEmailAndPassword(email, password);
		
		if(op.isEmpty())
		{
//			structure.setBody(null);
//			structure.setStatus(HttpStatus.NOT_FOUND.value());
//			structure.setMessage("employee not found ...");
//			return structure;
			throw InvalidCredentialsException.builder().message("Invalid Email and Password ").build();
		}
//		structure.setBody(op.get());
//		structure.setStatus(HttpStatus.OK.value());
//		structure.setMessage("employee found successfully.....");
//		return structure;
		
		
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("employee found successfully.....").body(op.get()).build());
	}
	public ResponseEntity<?> findEmployeeByName(String name)
	{
		List<Employee> employees=dao.findByName(name);
	
		if(employees.isEmpty())
		{
			throw  NoEmployeeFoundException.builder().message("No matching Employees found for the requested name...").build();
		}
		
		
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("all employees found successfully.....").body(employees).build());

		
	}
	
	public ResponseEntity<?> deleteEmployeeById(int id)
	{
		Optional<Employee> op = dao.findEmployeeById(id);
		if(op.isEmpty())
		{
			throw  InvalidEmployeeIdException.builder().message("Invalid ID ... No Employee Found with the specified id....").build();
		}
		dao.deleteEmployeeById(id);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message(" employee deleted  successful.....").body("Employee Found and Deleted").build());

	}

	public ResponseEntity<?> setEmployeeStatusToActive(int id) {
		
		Optional<Employee> op=dao.findEmployeeById(id);
		if(op.isEmpty())
		{
			throw  InvalidEmployeeIdException.builder().message("Invalid ID ... No Employee Found with the specified id....").build();
		}
		Employee e=op.get();
		e.setStatus(com.example.demo.util.EmployeeStatus.ACTIVE);
		e=dao.updateEmployee(e);
		
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Employee Status is set to Active ......").body(e).build());

	}

	public ResponseEntity<?> setEmployeeStatusToInActive(int id) {
		
		Optional<Employee> op=dao.findEmployeeById(id);
		if(op.isEmpty())
		{
			throw  InvalidEmployeeIdException.builder().message("Invalid ID ... No Employee Found with the specified id....").build();
		}
		Employee e=op.get();
		e.setStatus(com.example.demo.util.EmployeeStatus.IN_ACTIVE);
		e=dao.updateEmployee(e);
		
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Employee Status is set to IN_ACTIVE ......").body(e).build());

	}

	public ResponseEntity<?> setAllEmployeeActive() {
		
		List<Employee> employees=dao.findAllEmployee();
		for(Employee e:employees)
		{
			e.setStatus(EmployeeStatus.ACTIVE);
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("All employees set to active ......").body("All employees are active").build());

	}
	
	
	
}
