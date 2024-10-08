package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Education;
import com.example.demo.entity.Employee;

public interface EducationRepository extends JpaRepository<Education, Integer> 
{

	
	//@Query("Select ed from Education ed where ed.Employee=:e")
	@Query("SELECT e FROM Education e WHERE e.employee = :employee")
	List<Education> findAllEducation(Employee employee);

	

}
