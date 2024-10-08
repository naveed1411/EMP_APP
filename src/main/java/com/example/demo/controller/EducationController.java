package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Education;
import com.example.demo.service.EducationService;

@RestController
@RequestMapping("/educations")
public class EducationController {

	
//	postmap /educztions/{empid}
//	getmap /educations/{empid}
//	dm /educations/{id}/{empid}
	
	@Autowired
	private EducationService service;
	
	
	@PostMapping("/{empid}")
	public ResponseEntity<?> saveEducation(@RequestBody Education e,@PathVariable int empid)
	{
		return service.saveEducation(e,empid);
	}
	@GetMapping("/{empid}")
	public ResponseEntity<?> findAllEducation(@PathVariable int empid)
	{
		return service.findAllEducation(empid);
	}
	@DeleteMapping("/{empid}/{id}")
	public ResponseEntity<?> deleteEducation(@PathVariable int empid,@PathVariable int id)
	{
		return service.deleteEducation(empid,id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
