package com.abhishek.coursecreation.mapper;

import com.abhishek.coursecreation.dto.CreateRequest;
import com.abhishek.coursecreation.entity.CoursePrerequisite;
import com.abhishek.coursecreation.entity.CourseSchedule;
import com.abhishek.coursecreation.entity.Courses;
import com.abhishek.coursecreation.entity.SpecialisationCourse;
import com.abhishek.coursecreation.entity.Specialisation;
import org.springframework.stereotype.Service;

@Service
public class CreateMapper {

    public Courses toCourses(CreateRequest request) {
        Courses course = new Courses();
        course.setCourseCode(request.courseCode());
        course.setName(request.name());
        course.setDescription(request.description());
        course.setYear(request.year());
        course.setTerm(request.term());
        course.setFaculty(request.faculty());
        course.setCredits(request.credits());
        course.setCapacity(request.capacity());
        return course;
    }

    public CourseSchedule toCourseSchedule(CreateRequest request, Courses savedCourse) {
        CourseSchedule courseSchedule = new CourseSchedule();
        courseSchedule.setCourseId(savedCourse);
        courseSchedule.setTime(request.time());
        courseSchedule.setDay(request.day());
        courseSchedule.setRoom(request.room());
        courseSchedule.setBuilding(request.building());
        return courseSchedule;
    }

    public SpecialisationCourse toSpecialisationCourse(CreateRequest request, Courses savedCourse) {
        SpecialisationCourse specialisationCourse = new SpecialisationCourse();
        specialisationCourse.setSpecialisationId(request.specialisationId());//here we have to pass specialisation object
        specialisationCourse.setCourseId(savedCourse);
        return specialisationCourse;
    }

    public CoursePrerequisite toCoursePrequisite(CreateRequest request, Courses savedCourse) {
        CoursePrerequisite coursePrequisite = new CoursePrerequisite();
        coursePrequisite.setCourseId(savedCourse);
        coursePrequisite.setPrerequisite(request.prerequisite());//here we have to pass prerequisite an object of courses
        coursePrequisite.setDescription(request.preDescription());
        return coursePrequisite;
    }
}
