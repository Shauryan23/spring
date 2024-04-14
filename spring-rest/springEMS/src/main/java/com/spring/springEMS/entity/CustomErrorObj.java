package com.spring.springEMS.entity;

import lombok.Data;

@Data
public class CustomErrorObj {
	
	private Integer statusCode;
	
	private String message;
}
