package com.abhishek.coursecreation.repo;

import com.abhishek.coursecreation.entity.SpecialisationCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialisationCourseRepo extends JpaRepository<SpecialisationCourse, Long> {
}
