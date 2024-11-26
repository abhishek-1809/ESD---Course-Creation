package com.abhishek.coursecreation.repo;


import com.abhishek.coursecreation.entity.CourseSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseScheduleRepo extends JpaRepository<CourseSchedule,Long> {
}
