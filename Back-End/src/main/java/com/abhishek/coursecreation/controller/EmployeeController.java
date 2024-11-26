package com.abhishek.coursecreation.controller;

import com.abhishek.coursecreation.dto.CreateRequest;
import com.abhishek.coursecreation.dto.LoginRequest;
import com.abhishek.coursecreation.entity.*;
import com.abhishek.coursecreation.service.DataService;
import com.abhishek.coursecreation.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RequiredArgsConstructor
@RestController
public class EmployeeController {
    @Autowired
    private final EmployeeService employeeService;

    @Autowired
    private final DataService dataService;

    @GetMapping("/test")
    public ResponseEntity<String> testEndpoint() {
        System.out.println("testEndpoint ok");
        return ResponseEntity.ok("Test endpoint ok");
    }

    @PostMapping("/register")
    public Employees createCustomer(@RequestBody @Valid Employees employees) {
        return employeeService.register(employees);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginRequest request) {
        String response = employeeService.login(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create-course")
    public ResponseEntity<String> createCourse(@RequestBody @Valid CreateRequest request) {
        System.out.print("Printing at Control layer:");
        System.out.println(request);
        employeeService.createCourse(request);
//        return new ResponseEntity<>(request, HttpStatus.OK);
        return ResponseEntity.ok("Course created successfully!");
    }

    @GetMapping("/specialisation-names")
    public ResponseEntity<List<String>> getSpecialisationNames() {
        List<String> specialisationNames = dataService.getAllSpecialisationNames();
        return ResponseEntity.ok(specialisationNames);
    }

    @GetMapping("/course-names")
    public ResponseEntity<List<String>> getCourseNames() {
        List<String> courseNames = dataService.getAllCourseNames();
        return ResponseEntity.ok(courseNames);
    }
}
