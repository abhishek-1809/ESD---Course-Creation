package com.abhishek.coursecreation.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "specialisation")
public class Specialisation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "specialisation_id")
    private Integer specialisationId;

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "name")
    private String name;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "year")
    private Integer year;

    @Column(name = "credits_required")
    private Integer creditsRequired;

}
