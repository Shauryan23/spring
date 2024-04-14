package com.spring.springEMS.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.spring.springEMS.entity.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {

	boolean existsByEmployeeId(String employeeId);
    boolean existsByEmail(String email);
	
}
