package com.springEms.EmployeeService.service.implementation;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springEms.EmployeeService.dto.RegisterEmployeeDto;
import com.springEms.EmployeeService.dto.LoginEmployeeDto;
import com.springEms.EmployeeService.entity.Employee;
import com.springEms.EmployeeService.service.AuthenticationService;
import com.springEms.EmployeeService.repository.EmployeeRepository;

@Service
public class AuthenticationServiceImplmentation implements AuthenticationService {
	
    private final EmployeeRepository employeeRepository;
    
    private final PasswordEncoder passwordEncoder;
    
    private final AuthenticationManager authenticationManager;

    public AuthenticationServiceImplmentation(
        EmployeeRepository employeeRepository,
        AuthenticationManager authenticationManager,
        PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.employeeRepository = employeeRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Employee signup(RegisterEmployeeDto input) {
    	Employee employee = new Employee();
    	
    	employee.setName(input.getName());
    	employee.setEmail(input.getEmail());
    	employee.setPassword(passwordEncoder.encode(input.getPassword()));
    	
        return employeeRepository.save(employee);
    }

    public Employee authenticate(LoginEmployeeDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return employeeRepository.findByEmail(input.getEmail())
                .orElseThrow();
    }
}
