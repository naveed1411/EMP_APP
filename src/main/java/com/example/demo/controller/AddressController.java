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

import com.example.demo.entity.Address;
import com.example.demo.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressService service;
	
	@PostMapping("/{empid}")
	public ResponseEntity<?> saveAddress(@RequestBody Address address,@PathVariable int empid)
	{
		return service.saveAddress(address,empid);
	}
	@PatchMapping("/{empid}")
	public ResponseEntity<?> updateAddress(@RequestBody Address address, @PathVariable int empid)
	{
		return service.updateAddress(address, empid);
	}
	
	@GetMapping("/{empid}")
	public ResponseEntity<?> findAllAddress(@PathVariable int empid)
	{
		return service.findAllAddress(empid);
	}
	
	@DeleteMapping("/{empid}/{id}")
	public ResponseEntity<?> deleteAddress(@PathVariable int empid,@PathVariable int id)
	{
		return service.deleteAddress(empid,id);
	}
	@GetMapping
	public ResponseEntity<?> findAllAddresses()
	{
		return service.findAllAddresses();
	}

}
