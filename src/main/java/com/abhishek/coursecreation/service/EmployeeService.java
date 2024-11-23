package com.abhishek.coursecreation.service;

import com.abhishek.coursecreation.dto.CreateRequest;
import com.abhishek.coursecreation.dto.LoginRequest;
import com.abhishek.coursecreation.entity.*;
import com.abhishek.coursecreation.exception.EmployeeNotFoundException;
import com.abhishek.coursecreation.helper.EncryptionService;
import com.abhishek.coursecreation.helper.JWTHelper;
//import com.abhishek.coursecreation.mapper.EmployeeMapper;
import com.abhishek.coursecreation.repo.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepo repo;

//    @Autowired
//    EmployeeMapper mapper;

    @Autowired
    EncryptionService encryptionService;

    @Autowired
    JWTHelper jwtHelper;

    @Autowired
    AuthenticationManager authManager;

    //using mapper
//    public EmployeeResponse register(EmployeeRequest request) {
//        Employee employee = mapper.toEntity(request);
//        employee.setPassword(encryptionService.encode(employee.getPassword()));
//        Employee savedEmployee = repo.save(employee);
//        return mapper.toDto(savedEmployee);
//    }

    public Employee register(Employee employee) {
        employee.setPassword(encryptionService.encode(employee.getPassword()));
//        Employee savedEmployee = repo.save(employee);
        return repo.save(employee);

    }

    public String login(LoginRequest request) {
        Employee employee = repo.findByEmail(request.email());
        if (employee == null) {
            throw new EmployeeNotFoundException(format("Employee with email %s not found", request.email()));
        }
        if (employee.getDepartment() == null || !"Admin".equals(employee.getDepartment().getName())){
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

//    @Transactional
//    public void createCourse(Courses course,
//                             List<CourseSchedule> schedules,
//                             List<CoursePrerequisite> prerequisites,
//                             List<SpecialisationCourse> specialisations) {
//
//        // Save the course
//        Courses savedCourse = coursesRepo.save(course);
//
//        // Save the schedules
//        for (CourseSchedule schedule : schedules) {
//            schedule.setCourseId(savedCourse);
//            courseScheduleRepo.save(schedule);
//        }
//
//        // Save the prerequisites
//        for (CoursePrerequisite prerequisite : prerequisites) {
//            prerequisite.setCourseId(savedCourse);
//            coursePrerequisiteRepo.save(prerequisite);
//        }
//
//
//        // Save the specialisations
//        for (SpecialisationCourse specialisation : specialisations) {
//            specialisation.setCourseId(savedCourse);
//            specialisationCourseRepo.save(specialisation);
//        }
//    }


    public void createCourse(CreateRequest request) {
        Courses
    }
}
