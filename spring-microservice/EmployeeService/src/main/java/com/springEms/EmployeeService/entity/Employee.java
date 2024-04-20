package com.springEms.EmployeeService.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="employee")
public class Employee {
	@Id
	private String id;
	
	private long employeeId;
	
	private String name;
	
	private String email;
	
	private String position;
	
	private String department;
	
	private boolean projectAssigned;
	
	/*
	 * @DocumentReference(collection="manager") private Manager manager;
	 */
}
