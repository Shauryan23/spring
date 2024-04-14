package com.spring.springEMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.springEMS.entity.Manager;
import com.spring.springEMS.service.ManagerService;

@RestController
public class ManagerController {

	@Autowired
	private ManagerService managerService;
	
	@GetMapping("/managers")
	public String getAllManagers() {
		return "All Managers Page";
	}
	
	@PostMapping("/managers")
	public ResponseEntity<Manager> createManager(@RequestBody Manager manager) {
		Manager savedManager = managerService.createManager((manager));
        return new ResponseEntity<>(savedManager, HttpStatus.CREATED);
	}
	
}
