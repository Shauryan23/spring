package com.spring.springEMS.service.implmentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.springEMS.entity.Manager;
import com.spring.springEMS.repository.ManagerRepository;
import com.spring.springEMS.service.ManagerService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ManagerServiceImplementation implements ManagerService {

	@Autowired
	private ManagerRepository managerRepository;
	
	@Override
	public Manager createManager(Manager manager) {
		Manager savedManager = managerRepository.save(manager);
		return savedManager;
	}

	@Override
	public List<Manager> getAllManagers() {
		// TODO Auto-generated method stub
		return null;
	}

}
