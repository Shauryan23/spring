package com.springEms.EmployeeService.service;

import com.springEms.EmployeeService.dto.RegisterEmployeeDto;
import com.springEms.EmployeeService.dto.LoginEmployeeDto;
import com.springEms.EmployeeService.entity.Employee;

public interface AuthenticationService {

	public Employee signup(RegisterEmployeeDto input);
	
	public Employee authenticate(LoginEmployeeDto input);
	
}
