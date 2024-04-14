package com.spring.springEMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.springEMS.entity.Employee;
import com.spring.springEMS.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employees = employeeService.getAllEmployees();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}
	
	@GetMapping("employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable String id) {
		Employee employee = employeeService.getEmployeeById(id);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> createEmployee(@Validated @RequestBody Employee employee) {
	    employeeService.checkEmployeeExists(employee.getEmployeeId(), employee.getEmail());
	    System.out.println(employee.getEmployeeId());
		Employee savedEmployee = employeeService.createEmployee((employee));
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployeeById(@PathVariable String id,@Validated @RequestBody Employee employee) {
		Employee updatedEmployee = employeeService.updateEmployeeById(id, employee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable String id) {
		boolean isDeleted = employeeService.deleteEmployeeById(id);
		
		if(isDeleted) {
			return new ResponseEntity<>("Employee with ID " + id + " has been deleted successfully.", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Employee with ID " + id + " not found.", HttpStatus.NOT_FOUND);
		}
	}
}
