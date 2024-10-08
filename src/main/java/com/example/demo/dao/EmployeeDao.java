package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@Component
public class EmployeeDao {

	@Autowired
	private EmployeeRepository repository;
	
	public Employee saveEmployee(Employee employee)
	{
		return repository.save(employee);
	}
	
	public Employee updateEmployee(Employee employee)
	{
		return repository.save(employee);
	}
	public Optional<Employee> findEmployeeById(int id)
	{
		return repository.findById(id);
	}
	public List<Employee> findAllEmployee()
	{
		return repository.findAll();
	}
	public List<Employee> findAllActiveEmployee()
	{
		return repository.findAllActiveEmployee0();
	}
	
	public void deleteEmployeeById(int id)
	{
		 repository.deleteById(id);
	}
	public Optional<Employee> findEmployeeByEmailAndPassword(String email,String password)
	{
		return repository.findByEmailAndPassword(email,password);
	}
	
	public List<Employee> findByName(String name)
	{
		return repository.findByName(name);
	}

	

}
