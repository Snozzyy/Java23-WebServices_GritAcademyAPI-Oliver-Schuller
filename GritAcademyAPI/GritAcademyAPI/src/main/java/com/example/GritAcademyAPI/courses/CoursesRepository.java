package com.example.GritAcademyAPI.courses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CoursesRepository extends JpaRepository<Courses, Integer> {
    List<Courses> findByName(String name);
    List<Courses> findByNameContaining(String keyword);
    List<Courses> findByDescriptionContaining(String keyword);
}
