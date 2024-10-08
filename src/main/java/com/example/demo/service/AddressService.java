package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AddressDao;
import com.example.demo.dao.EmployeeDao;
import com.example.demo.entity.Address;
import com.example.demo.entity.Education;
import com.example.demo.entity.Employee;
import com.example.demo.exceptionclasses.NoActiveEmployeeFoundException;
import com.example.demo.exceptionclasses.NoAddressesFoundException;
import com.example.demo.exceptionclasses.NoEducationFoundException;
import com.example.demo.responsestructure.ResponseStructure;
import com.example.demo.service.exceptionclasses.NoAddressFoundException;
import com.example.demo.util.AddressType;
@Service
public class AddressService {
	
	@Autowired
	private AddressDao dao;

	@Autowired
	private EmployeeDao empdao;

	public ResponseEntity<?> saveAddress(Address address, int empid) {
		Optional<Employee> op=empdao.findEmployeeById(empid);
		if(op.isEmpty())
		{
			throw NoActiveEmployeeFoundException.builder().message("no employee found").build();
		}
		address.setEmployee(op.get());
		address.setAddressType(AddressType.PERMANENT);
		address=dao.saveAddress(address);
		return ResponseEntity.status(HttpStatus.CREATED).body(ResponseStructure.builder().status(HttpStatus.CREATED.value()).message("address saved successfully").body(address).build());
	}


	public ResponseEntity<?> updateAddress(Address address, int empid) {
		Optional<Employee> op=empdao.findEmployeeById(empid);
		if(op.isEmpty())
		{
			throw NoActiveEmployeeFoundException.builder().message("no employee found").build();
		}
		address=dao.saveAddress(address);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.CREATED.value()).message("address saved successfully").body(address).build());
	}


	public ResponseEntity<?> findAllAddress(int empid) {
		Optional<Employee> op=empdao.findEmployeeById(empid);
		if(op.isEmpty())
		{
			throw NoActiveEmployeeFoundException.builder().message("no employee found").build();
		}
		Employee e=op.get();
		List<Address> addresses=dao.findAllAddress(e);
		if(addresses.isEmpty())
			throw NoAddressesFoundException.builder().message("no addresses for employee ").build();
			//return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder().status(HttpStatus.NOT_FOUND.value()).message("No addresses found for this employee").body("The specified employee has not given his address..........").build());

		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.CREATED.value()).message("address fetched successfully").body(addresses).build());

	}


	public ResponseEntity<?> deleteAddress(int empid, int id) {
		Optional<Employee> op=empdao.findEmployeeById(empid);
		if(op.isEmpty())
		{
			throw NoActiveEmployeeFoundException.builder().message("no employee found").build();
		}
		List<Address> addresses=dao.findAllAddress(op.get());
		Optional<Address> opadd=dao.findAddressById(id);
		if(opadd.isEmpty())
			throw  NoAddressFoundException.builder().message("No Address Found of this id  ").build();
	 
		if(addresses.contains(opadd.get()))
			dao.deleteAddressById(id);
			
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Address deleted Successfully").body("Address deletion success.....").build());
		
	}


	public ResponseEntity<?> findAllAddresses() {
		List<Address> addresses=dao.findAllAddresses();
		
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Address fetched Successfully").body(addresses).build());

	}

	
	
	
	
	
	
	
	
	
	
	
}
