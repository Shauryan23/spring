package com.spring.springEMS.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.spring.springEMS.dto.EmployeeDto;
import com.spring.springEMS.entity.Employee;

@Mapper
public interface AutoEmployeeMapper {
	
	AutoEmployeeMapper MAPPER = Mappers.getMapper(AutoEmployeeMapper.class);
	
	EmployeeDto mapToEmployeeDto(Employee employee);
	
	Employee mapToEmployee(EmployeeDto employeeDto);
}
