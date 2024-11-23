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
    private int courseId;

    @Column(name="course_code", nullable = false, unique = true)
    private String courseCode;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="year")
    private int year;

    @Column(name="term")
    private int term;

    @Column(name="faculty")
    private String faculty;

    @Column(name="credits")
    private int credits;

    @Column(name="capacity")
    private int capacity;
}
