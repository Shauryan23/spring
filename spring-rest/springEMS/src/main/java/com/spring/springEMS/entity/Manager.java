package com.spring.springEMS.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection="manager")
public class Manager {
	
	@Id
	private String id;
	
	private long managerId;
	
	private String name;
	
	private String email;
	
	private String department;
	
	private boolean projectAssigned;
}
