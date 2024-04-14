package com.spring.springEMS.dto;

import com.spring.springEMS.entity.Manager;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
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
	
	private Manager manager;
}
