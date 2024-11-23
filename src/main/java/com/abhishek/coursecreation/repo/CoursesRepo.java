package com.abhishek.coursecreation.repo;

import com.abhishek.coursecreation.entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepo extends JpaRepository<Courses, Long> {
}
