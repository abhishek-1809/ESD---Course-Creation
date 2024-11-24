package com.abhishek.coursecreation.repo;

import com.abhishek.coursecreation.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employees, Long> {
    Employees findByEmail(String email);
}
