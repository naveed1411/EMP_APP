package com.example.demo.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Education;
import com.example.demo.entity.Employee;
import com.example.demo.repository.EducationRepository;

@Component
public class EducationDao {

	@Autowired
	private EducationRepository repository;
	
public Education saveEducation(Education education)
{
	return repository.save(education);
}
public Education upadteEducation(Education education)
{
	return repository.save(education);
}
public List<Education> findAllEducation(Employee e)
{
	return repository.findAllEducation(e);
}
public Optional<Education> findEducationById(int id) {
	return repository.findById(id);
}
public void deleteEducationById(int id) {
	 repository.deleteById(id);
	
	
}
	
	
	
}
