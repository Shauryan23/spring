package com.spring.springEMS.service;

import java.util.List;

import com.spring.springEMS.entity.Manager;

public interface ManagerService {
	Manager createManager(Manager manager);
	
	List<Manager> getAllManagers();
}
