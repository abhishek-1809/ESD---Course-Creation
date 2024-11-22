package com.abhishek.coursecreation.enity;

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

    @Column(name="course_code", nullable = false, unique = true, length = 255)
    private String courseCode;

    @Column(name="year")
    private int year;

    @Column(name="term")
    private int term;

    @Column(name="faculty", length = 255)
    private String faculty;

    @Column(name="credits")
    private int credits;

    @Column(name="capacity")
    private int capacity;
}
