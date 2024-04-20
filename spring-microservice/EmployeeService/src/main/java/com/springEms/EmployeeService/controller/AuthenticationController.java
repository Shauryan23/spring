package com.springEms.EmployeeService.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springEms.EmployeeService.config.JwtService;
import com.springEms.EmployeeService.config.LoginResponse;
import com.springEms.EmployeeService.dto.RegisterEmployeeDto;
import com.springEms.EmployeeService.dto.LoginEmployeeDto;
import com.springEms.EmployeeService.entity.Employee;
import com.springEms.EmployeeService.service.AuthenticationService;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {

private final JwtService jwtService;
    
    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<Employee> register(@RequestBody RegisterEmployeeDto registerEmployeeDto) {
        Employee registeredEmployee = authenticationService.signup(registerEmployeeDto);

        return ResponseEntity.ok(registeredEmployee);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginEmployeeDto loginEmployeeDto) {
        Employee authenticatedEmployee = authenticationService.authenticate(loginEmployeeDto);

        String jwtToken = jwtService.generateToken(authenticatedEmployee);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
	
}
