//package com.abhishek.coursecreation.mapper;
//
//import com.abhishek.coursecreation.dto.EmployeeRequest;
//import com.abhishek.coursecreation.dto.EmployeeResponse;
//import com.abhishek.coursecreation.enity.Employee;
//import org.springframework.stereotype.Service;
//
//@Service
//public class EmployeeMapper {
//    public Employee toEntity(EmployeeRequest request) {
//        Employee employee = new Employee();
//        employee.setFirstName(request.first_name());
//        employee.setLastName(request.last_name());
//        employee.setEmail(request.email());
//        employee.setTitle(request.title());
//        employee.setPhotographPath(request.photograph_path());
//        employee.setDepartment(request.department());
//        employee.setPassword(request.password());
//        return employee;
//    }
//
//    public EmployeeResponse toDto(Employee employee) {
//        return new EmployeeResponse(
//                employee.getFirstName(),
//                employee.getLastName(),
//                employee.getEmail()
//        );
//    }
//}
