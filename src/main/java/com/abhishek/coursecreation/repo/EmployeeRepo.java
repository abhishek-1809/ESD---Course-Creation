package com.abhishek.coursecreation.repo;

import com.abhishek.coursecreation.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    Employee findByEmail(String email);
}
