package com.abhishek.coursecreation.repo;

import com.abhishek.coursecreation.entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursesRepo extends JpaRepository<Courses, Long> {
    Courses findByName(String name);
}
