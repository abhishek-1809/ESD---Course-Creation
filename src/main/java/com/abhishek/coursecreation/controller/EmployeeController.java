package com.abhishek.coursecreation.controller;

import com.abhishek.coursecreation.dto.CreateRequest;
import com.abhishek.coursecreation.dto.LoginRequest;
import com.abhishek.coursecreation.entity.*;
import com.abhishek.coursecreation.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

//    @PostMapping("/create-course")
//    public ResponseEntity<String> createCourse(
//            @RequestBody Courses course,
//            @RequestBody List<CourseSchedule> schedules,
//            @RequestBody List<CoursePrerequisite> prerequisites,
//            @RequestBody List<SpecialisationCourse> specialisations) {
//
//        employeeService.createCourse(course, schedules, prerequisites, specialisations);
//        return ResponseEntity.ok("Course created successfully!");
//    }

    @PostMapping("/create-course")
    public ResponseEntity<String> createCourse(CreateRequest request) {
        employeeService.createCourse(request);
        return ResponseEntity.ok("Course created successfully!");
    }
}
