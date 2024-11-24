package com.abhishek.coursecreation.service;

import com.abhishek.coursecreation.dto.CreateRequest;
import com.abhishek.coursecreation.dto.LoginRequest;
import com.abhishek.coursecreation.entity.*;
import com.abhishek.coursecreation.exception.EmployeeNotFoundException;
import com.abhishek.coursecreation.helper.EncryptionService;
import com.abhishek.coursecreation.helper.JWTHelper;
import com.abhishek.coursecreation.mapper.CreateMapper;
import com.abhishek.coursecreation.repo.*;
//import jakarta.transaction.Transactional;
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

//    @Autowired
//    EmployeeMapper mapper;

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

    //using mapper
//    public EmployeeResponse register(EmployeeRequest request) {
//        Employee employee = mapper.toEntity(request);
//        employee.setPassword(encryptionService.encode(employee.getPassword()));
//        Employee savedEmployee = repo.save(employee);
//        return mapper.toDto(savedEmployee);
//    }

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
        System.out.print("Printing at Service:");
        System.out.println(request);
        Courses course = mapper.toCourses(request);
        Courses savedCourse = coursesRepo.save(course);

        Integer cid = savedCourse.getCourseId();

        CourseSchedule courseSchedule = mapper.toCourseSchedule(request,savedCourse);
        courseScheduleRepo.save(courseSchedule);

        Specialisation specialisation = specialisationRepo.findByName(request.specialisationName());
        SpecialisationCourse specialisationCourse = mapper.toSpecialisationCourse(request,savedCourse,specialisation);
        specialisationCourseRepo.save(specialisationCourse);

        Courses courseForPre = coursesRepo.findByName(request.prerequisiteName());
        CoursePrerequisite coursePrerequisite = mapper.toCoursePrequisite(request,savedCourse,courseForPre);
        coursePrerequisiteRepo.save(coursePrerequisite);

    }
}
