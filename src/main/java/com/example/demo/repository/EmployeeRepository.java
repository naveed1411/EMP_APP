package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer >
{

	Optional<Employee> findByEmailAndPassword(String email, String password);

	List<Employee> findByName(String name);

	@Query("Select e from Employee e where e.status='ACTIVE'")
	List<Employee> findAllActiveEmployee0();

}
