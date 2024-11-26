package com.abhishek.coursecreation.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "courses")
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Integer courseId;

    @Column(name="course_code", nullable = false, unique = true)
//    @Column(name="course_code")
    private String courseCode;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="year")
    private Integer year;

    @Column(name="term")
    private Integer term;

    @Column(name="faculty")
    private String faculty;

    @Column(name="credits")
    private Integer credits;

    @Column(name="capacity")
    private Integer capacity;
}
