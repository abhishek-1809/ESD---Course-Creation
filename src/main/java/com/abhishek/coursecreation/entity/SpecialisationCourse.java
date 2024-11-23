package com.abhishek.coursecreation.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "specialisation_course")
public class SpecialisationCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
//    @JoinColumn(name = "specialisation_id", referencedColumnName = "specialisation_id", nullable = true)
    @JoinColumn(name = "specialisation_id")
    private Specialisation specialisation;

    @ManyToOne
//    @JoinColumn(name = "course_id", referencedColumnName = "course_id", nullable = true)
    @JoinColumn(name = "course_id")
    private Courses courseId;
}
