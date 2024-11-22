package com.abhishek.coursecreation.enity;

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

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "capacity")
    private Integer capacity;
}
