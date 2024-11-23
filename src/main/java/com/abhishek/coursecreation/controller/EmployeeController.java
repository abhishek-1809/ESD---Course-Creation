package com.abhishek.coursecreation.controller;

import com.abhishek.coursecreation.dto.LoginRequest;
import com.abhishek.coursecreation.entity.Employee;
import com.abhishek.coursecreation.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequiredArgsConstructor
@RestController
public class EmployeeController {
    @Autowired
    private final EmployeeService employeeService;

    @GetMapping("/test")
    public ResponseEntity<String> testEndpoint() {
        System.out.println("testEndpoint ok");
        return ResponseEntity.ok("Test endpoint ok");
    }

    //using mapper
//    @PostMapping("/register")
//    public ResponseEntity<EmployeeResponse> createCustomer(@RequestBody @Valid EmployeeRequest request) {
//        EmployeeResponse response = employeeService.register(request);
//        return ResponseEntity.ok(response);
//    }

    @PostMapping("/register")
    public Employee createCustomer(@RequestBody @Valid Employee employee) {
        return employeeService.register(employee);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginRequest request) {
        String response = employeeService.login(request);
        return ResponseEntity.ok(response);
    }

}
