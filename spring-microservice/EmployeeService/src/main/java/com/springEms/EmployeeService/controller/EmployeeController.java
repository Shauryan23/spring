package com.springEms.EmployeeService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springEms.EmployeeService.dto.EmployeeDto;
import com.springEms.EmployeeService.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public ResponseEntity<List<EmployeeDto>> getAllEmployee() {
		List<EmployeeDto> employeesList = employeeService.getAllEmployees();
		return new ResponseEntity<List<EmployeeDto>>(employeesList, HttpStatus.OK);
	}
}
