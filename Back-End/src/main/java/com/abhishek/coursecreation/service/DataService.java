package com.abhishek.coursecreation.service;

import com.abhishek.coursecreation.entity.Courses;
import com.abhishek.coursecreation.entity.Specialisation;
import com.abhishek.coursecreation.repo.CoursesRepo;
import com.abhishek.coursecreation.repo.SpecialisationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataService {
    @Autowired
    SpecialisationRepo specialisationRepo;

    @Autowired
    CoursesRepo coursesRepo;


    public List<String> getAllSpecialisationNames() {
        List<Specialisation> specialisations = specialisationRepo.findAll();
        List<String> specialisationNames = new ArrayList<>();

        for (Specialisation specialisation : specialisations) {
            specialisationNames.add(specialisation.getName());
        }
        return specialisationNames;
    }

    public List<String> getAllCourseNames() {
        List<Courses> courses = coursesRepo.findAll();
        List<String> courseNames = new ArrayList<>();

        for (Courses course : courses) {
            courseNames.add(course.getName());
        }

        return courseNames;
    }
}
