package com.abhishek.coursecreation.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;

import java.util.Date;

@Data
@Entity
@Table(name = "course_schedule")
public class CourseSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "course_id")
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
