package com.springEms.EmployeeService.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.springEms.EmployeeService.dto.EmployeeDto;

public interface EmployeeService {
	public List<EmployeeDto> getAllEmployees();
}
