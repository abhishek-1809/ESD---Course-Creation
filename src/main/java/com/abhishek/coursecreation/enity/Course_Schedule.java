package com.abhishek.coursecreation.enity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "course_schedule")
public class Course_Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = true, referencedColumnName = "course_id")
    private Courses courseId;

    @Temporal(TemporalType.DATE)
    @Column(name = "time")
    private Date time;

    @Column(name = "day")
    private String day;

    @Column(name = "room")
    private String room;

    @Column(name = "building")
    private String building;
}
