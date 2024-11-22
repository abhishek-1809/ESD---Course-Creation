package com.abhishek.coursecreation.enity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "first_name", nullable = true, length = 255)
    private String firstName;

    @Column(name = "last_name", nullable = true, length = 255)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true, length = 255)
    private String email;

    @Column(name = "title", nullable = true, length = 255)
    private String title;

    @Column(name = "photograph_path", nullable = true, length = 255)
    private String photographPath;

    @ManyToOne  // Many employees can belong to one department
    @JoinColumn(name = "department", referencedColumnName = "department_id")  // Foreign key column
    private Department department;

    @Column(name = "password", nullable = true, length = 255)
    private String password;
}
