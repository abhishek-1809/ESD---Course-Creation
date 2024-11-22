package com.abhishek.coursecreation.enity;

import jakarta.persistence.*;

@Entity
@Table(name = "specialisation_course")
public class SpecialisationCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "specialisation_id", referencedColumnName = "specialisation_id", nullable = true)
    private Specialisation specialisation;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "course_id", nullable = true)
    private Courses course;
}
