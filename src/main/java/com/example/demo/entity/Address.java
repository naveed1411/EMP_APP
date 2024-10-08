package com.example.demo.entity;

import com.example.demo.util.AddressType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
@Data
@Entity
public class Address {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int doorNo;
	private String streetAddress;
	private String addressLine2;
	private String city;
	private String state;
	private String country;
	private String postalCode;
	private AddressType  addressType; // Can be an enum   PERMANENT , PRESENT
	
	
	@ManyToOne
	private Employee employee;
}
