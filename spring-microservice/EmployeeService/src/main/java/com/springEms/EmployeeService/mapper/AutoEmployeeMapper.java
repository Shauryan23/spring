package com.springEms.EmployeeService.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.springEms.EmployeeService.entity.Employee;
import com.springEms.EmployeeService.dto.EmployeeDto;

@Mapper
public interface AutoEmployeeMapper {
	
	AutoEmployeeMapper MAPPER = Mappers.getMapper(AutoEmployeeMapper.class);

	EmployeeDto mapToEmployeeDto(Employee employee);
	
	Employee mapToEmployee(EmployeeDto employeeDto);
}
