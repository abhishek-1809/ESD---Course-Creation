package com.abhishek.coursecreation.service;

import com.abhishek.coursecreation.dto.CreateRequest;
import com.abhishek.coursecreation.dto.LoginRequest;
import com.abhishek.coursecreation.entity.*;
import com.abhishek.coursecreation.exception.EmployeeNotFoundException;
import com.abhishek.coursecreation.helper.EncryptionService;
import com.abhishek.coursecreation.helper.JWTHelper;
import com.abhishek.coursecreation.mapper.CreateMapper;
import com.abhishek.coursecreation.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepo repo;


    @Autowired
    CreateMapper mapper;

    @Autowired
    EncryptionService encryptionService;

    @Autowired
    JWTHelper jwtHelper;

    @Autowired
    AuthenticationManager authManager;
    @Autowired
    private SpecialisationRepo specialisationRepo;


    public Employees register(Employees employees) {
        employees.setPassword(encryptionService.encode(employees.getPassword()));
//        Employee savedEmployee = repo.save(employee);
        return repo.save(employees);

    }

    public String login(LoginRequest request) {
        Employees employees = repo.findByEmail(request.email());
        if (employees == null) {
            throw new EmployeeNotFoundException(format("Employee with email %s not found", request.email()));
        }
        if (employees.getDepartment() == null || !"Admin".equals(employees.getDepartment().getName())){
            throw new EmployeeNotFoundException(format("Employee with email %s not found in Admin department", request.email()));
        }
        Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(request.email(), request.password()));
        if(auth.isAuthenticated())
            return jwtHelper.generateToken(request.email());

        return "Wrong Username or Password";
    }

    @Autowired
    private CoursesRepo coursesRepo;

    @Autowired
    private CourseScheduleRepo courseScheduleRepo;

    @Autowired
    private CoursePrerequisiteRepo coursePrerequisiteRepo;

    @Autowired
    private SpecialisationCourseRepo specialisationCourseRepo;


    public void createCourse(CreateRequest request) {
        System.out.print("Printing at Service:");
        System.out.println(request);
        Courses course = mapper.toCourses(request);
        Courses savedCourse = coursesRepo.save(course);

        for(String d : request.day()) {
            CourseSchedule courseSchedule = mapper.toCourseSchedule(request, savedCourse, d);
            courseScheduleRepo.save(courseSchedule);
        }

        Specialisation specialisation = specialisationRepo.findByName(request.specialisationName());
        SpecialisationCourse specialisationCourse = mapper.toSpecialisationCourse(request,savedCourse,specialisation);
        specialisationCourseRepo.save(specialisationCourse);

        for(String pn : request.prerequisiteName()) {
            Courses courseForPre = coursesRepo.findByName(pn);
            CoursePrerequisite coursePrerequisite = mapper.toCoursePrequisite(request, savedCourse, courseForPre);
            coursePrerequisiteRepo.save(coursePrerequisite);
        }
    }
}
