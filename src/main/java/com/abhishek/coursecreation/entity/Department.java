package com.abhishek.coursecreation.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Integer departmentId;

    @Column(name = "name")
    private String name;

    @Column(name = "capacity")
    private Integer capacity;
}
