package com.abhishek.coursecreation.repo;


import com.abhishek.coursecreation.entity.Course_Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseScheduleRepo extends JpaRepository<Course_Schedule,Long> {
}
