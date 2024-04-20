package com.springEms.EmployeeService.service.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springEms.EmployeeService.dto.EmployeeDto;
import com.springEms.EmployeeService.entity.Employee;
import com.springEms.EmployeeService.mapper.AutoEmployeeMapper;
import com.springEms.EmployeeService.repository.EmployeeRepository;
import com.springEms.EmployeeService.service.EmployeeService;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		
		return employees.stream()
						.map((employee) -> AutoEmployeeMapper.MAPPER.mapToEmployeeDto(employee))
						.collect(Collectors.toList());
	}

}
