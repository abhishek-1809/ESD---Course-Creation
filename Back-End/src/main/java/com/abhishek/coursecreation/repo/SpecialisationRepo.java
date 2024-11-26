package com.abhishek.coursecreation.repo;

import com.abhishek.coursecreation.entity.Specialisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialisationRepo extends JpaRepository<Specialisation, Long> {
    Specialisation findByName(String name);
}
