package com.springEms.EmployeeService.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
	
	private String id;
	
	private long employeeId;
	
	private String name;
	
	private String email;
	
	private String position;
	
	private String department;
	
	private boolean projectAssigned;
	
}
