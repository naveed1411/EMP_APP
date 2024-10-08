package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Address;
import com.example.demo.entity.Employee;
import com.example.demo.repository.AddressRespository;

@Component
public class AddressDao {

	@Autowired
	private AddressRespository repository;
	
	public Address saveAddress(Address address)
	{
		return repository.save(address);
	}
	public Address updateAddress(Address address)
	{
		return repository.save(address);
	}
	public List<Address> findAllAddress(Employee employee)
	{
		return repository.findAllAddressByEmployee(employee);
	}
	public Optional<Address> findAddressById(int id)
	{
		return repository.findById(id);
	}
	public void deleteAddressById(int id)
	{
		 repository.deleteById(id);
	}
	public List<Address> findAllAddresses() {
		return repository.findAll();
	}
	
}
