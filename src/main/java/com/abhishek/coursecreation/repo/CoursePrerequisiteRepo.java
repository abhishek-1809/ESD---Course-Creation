package com.abhishek.coursecreation.repo;

import com.abhishek.coursecreation.entity.CoursePrerequisite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursePrerequisiteRepo extends JpaRepository<CoursePrerequisite, Long> {
}
