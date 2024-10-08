package com.example.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EducationDao;
import com.example.demo.dao.EmployeeDao;
import com.example.demo.entity.Education;
import com.example.demo.entity.Employee;
import com.example.demo.exceptionclasses.NoActiveEmployeeFoundException;
import com.example.demo.exceptionclasses.NoEducationFoundException;
import com.example.demo.responsestructure.ResponseStructure;
import com.example.demo.util.HighestQualification;
@Service
public class EducationService {
	
@Autowired	
 private EducationDao dao;
@Autowired
private EmployeeDao empdao;

public ResponseEntity<?> saveEducation(Education education,int empid)
{
	Optional<Employee> op=empdao.findEmployeeById(empid);
	if(op.isEmpty())
	{
		throw NoActiveEmployeeFoundException.builder().message("no employee found").build();
	}
	education.setHighestQualification(HighestQualification.NO);
	 
	 education.setEmployee(op.get());
	 education=dao.saveEducation(education);
	return ResponseEntity.status(HttpStatus.CREATED).body(ResponseStructure.builder().status(HttpStatus.CREATED.value()).message("Education Created Successfully").body(education).build());
}
public ResponseEntity<?> updateEducation(Education education)
{
	education=dao.upadteEducation(education);
	return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Education Updated  Successfully").body(education).build());
}
public ResponseEntity<?> findAllEducation(int empid)
{
	Optional<Employee> op=empdao.findEmployeeById(empid);
	if(op.isEmpty())
	{
		throw NoActiveEmployeeFoundException.builder().message("no employee found").build();
	}
	
	List<Education> educations=dao.findAllEducation(op.get());
	if(educations.isEmpty())
	{
		throw  NoEducationFoundException.builder().message("No Education Found ").build();
	}
	return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Education fetched Successfully").body(educations).build());
}


public ResponseEntity<?> deleteEducation(int empid,int id)
{
	Optional<Employee> op=empdao.findEmployeeById(empid);
	if(op.isEmpty())
	{
		throw NoActiveEmployeeFoundException.builder().message("no employee found").build();
	}
	List<Education> educations=dao.findAllEducation(op.get());
	if(educations.isEmpty())
	{
		throw  NoEducationFoundException.builder().message("No Education Found ").build();
	}
	Optional<Education> oped=dao.findEducationById(id);
	if(oped.isEmpty())
		throw  NoEducationFoundException.builder().message("No Education Found ").build();
 
	if(educations.contains(oped.get()))
		dao.deleteEducationById(id);
		
	return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Education deleted Successfully").body("deletion successfull....").build());


	
	
}




}
