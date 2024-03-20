package com.example.GritAcademyAPI.courses;

import com.example.GritAcademyAPI.students.Students;
import com.example.GritAcademyAPI.students.StudentsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CoursesService {
    @Autowired
    CoursesRepository coursesRepository;

    public List<CoursesDTO> findAll(){
        // Use coursesMapToDTO, prevents messy response
        return coursesRepository.findAll().stream().map(this::coursesMapToDTO).collect(Collectors.toList());
    }
    public List<CoursesDTO> findById(Long id) {
        Optional<Courses> course = coursesRepository.findById(Math.toIntExact(id));
        return course.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public List<CoursesDTO> findByName(String name) {
        List<Courses> course = coursesRepository.findByName(name);
        return course.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public List<CoursesDTO> findByNameContaining(String keyword) {
        List<Courses> courses = coursesRepository.findByNameContaining(keyword);
        return courses.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public List<CoursesDTO> findByDescriptionContaining(String keyword) {
        List<Courses> courses = coursesRepository.findByDescriptionContaining(keyword);
        return courses.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    // DTO shows information about course and students assigned
    private CoursesDTO mapToDTO(Courses courses){
        CoursesDTO dto = new CoursesDTO();
        dto.setId(courses.getId());
        dto.setName(courses.getName());
        dto.setDescription(courses.getDescription());
        dto.setStudents(courses.getStudents().stream().map(this::mapToDTO).collect(Collectors.toList()));

        return dto;
    }

    // DTO which doesn't show all students assigned to course
    private CoursesDTO coursesMapToDTO(Courses courses) {
        CoursesDTO dto = new CoursesDTO();
        dto.setId(courses.getId());
        dto.setName(courses.getName());
        dto.setDescription(courses.getDescription());
        return dto;
    }

    // DTO shows information about students
    private StudentsDTO mapToDTO(Students students) {
        StudentsDTO dto = new StudentsDTO();
        dto.setId(students.getId());
        dto.setFname(students.getFname());
        dto.setLname(students.getLname());
        dto.setTown(students.getTown());

        return dto;
    }
}
