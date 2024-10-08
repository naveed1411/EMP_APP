package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Address;
import com.example.demo.entity.Employee;

public interface AddressRespository extends JpaRepository<Address, Integer>
{

	@Query("Select a from Address a where a.employee=:employee")
	List<Address> findAllAddressByEmployee(Employee employee);

}
