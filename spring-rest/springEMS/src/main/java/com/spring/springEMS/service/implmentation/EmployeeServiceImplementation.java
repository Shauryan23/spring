package com.spring.springEMS.service.implmentation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.springEMS.entity.Employee;
import com.spring.springEMS.exception.ResourceNotFoundException;
import com.spring.springEMS.repository.EmployeeRepository;
import com.spring.springEMS.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImplementation implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public void checkEmployeeExists(String employeeId, String email) {
	    if (employeeId != null && employeeRepository.existsByEmployeeId(employeeId)) {
	        throw new IllegalArgumentException("Employee with ID " + employeeId + " already exists");
	    }
	    if (email != null && employeeRepository.existsByEmail(email)) {
	        throw new IllegalArgumentException("Employee with email " + email + " already exists");
	    }
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
				
		return employees;
	}

	@Override
	public Employee getEmployeeById(String id) {
		Optional<Employee> filteredEmployee = employeeRepository.findById(id);
		
		Employee employee = filteredEmployee.orElseThrow(() -> new ResourceNotFoundException("Employee Not Found!"));

	    return employee;
	}
	
	@Override
	public Employee createEmployee(Employee employee) {
		
		if (employee == null) {
	        throw new IllegalArgumentException("Employee object cannot be null");
	    }
		
		Employee savedEmployee = employeeRepository.save(employee);
		
		if (savedEmployee == null) {
	        throw new IllegalStateException("Failed to save employee");
	    }
		
		return savedEmployee;
	}

	@Override
	public boolean deleteEmployeeById(String id) {
		// employeeRepository.deleteById(id);
		Optional<Employee> employeeOptional = employeeRepository.findById(id);
		
        if (employeeOptional.isPresent()) {
            employeeRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
	}

	@Override
	public Employee updateEmployeeById(String id, Employee employee) {
		Employee existingEmployee = getEmployeeById(id);
		
	    existingEmployee.setName(employee.getName() != null ? employee.getName() : existingEmployee.getName());
	    existingEmployee.setEmail(employee.getEmail() != null ? employee.getEmail() : existingEmployee.getEmail());
	    existingEmployee.setPosition(employee.getPosition() != null ? employee.getPosition() : existingEmployee.getPosition());
	    existingEmployee.setDepartment(employee.getDepartment() != null ? employee.getDepartment() : existingEmployee.getDepartment());
	    existingEmployee.setProjectAssigned(employee.isProjectAssigned());
	    existingEmployee.setManager(employee.getManager() != null ? employee.getManager() : existingEmployee.getManager());
		
	    return employeeRepository.save(existingEmployee);
	}
	
}
