package com.example.demo.entity;

import com.example.demo.util.HighestQualification;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;


@Data
@Entity
public class Education {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int educationId;
	private String qualification;
	private String universityName;
	private double percentage;
	private int completionYear;
	private HighestQualification highestQualification; // YES - NO
	
	@ManyToOne
	private Employee employee;
	
}
