package com.spring.springEMS.service;

import java.util.List;
import com.spring.springEMS.entity.Employee;

public interface EmployeeService {
	
	void checkEmployeeExists(String employeeId, String email);
	
	List<Employee> getAllEmployees();
	
	Employee getEmployeeById(String id);
	
	Employee createEmployee(Employee employee);
	
	Employee updateEmployeeById(String id, Employee employee);
	
	boolean deleteEmployeeById(String id);
}
