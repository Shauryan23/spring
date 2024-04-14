package com.spring.springEMS.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection="employee")
public class Employee {
	
	@Id
	private String id;
	
	@NotBlank
	@Positive
	private String employeeId;
	
	@NotBlank(message = "Name is required")
	private String name;
	
	@Email(message = "Email should be valid")
	private String email;
	
	@NotBlank(message = "Position is required")
	private String position;
	
	@NotBlank(message = "Department is required")
	private String department;
	
	@NotNull(message = "Project assigned flag is required")
	private boolean projectAssigned;
	
	@DocumentReference(collection="manager")
	private Manager manager;
}
