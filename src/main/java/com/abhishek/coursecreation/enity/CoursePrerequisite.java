package com.abhishek.coursecreation.enity;

import jakarta.persistence.*;

@Entity
@Table(name = "course_prerequisite")
public class CoursePrerequisite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "course_id", nullable = true)
    private Courses courseId;

    @ManyToOne
    @JoinColumn(name = "prerequisite", referencedColumnName = "course_id", nullable = true)
    private Courses prerequisite;

    @Lob
    @Column(name = "description")
    private String description;
}