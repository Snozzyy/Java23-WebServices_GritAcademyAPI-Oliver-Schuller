package com.example.GritAcademyAPI.courses;

import com.example.GritAcademyAPI.students.StudentsDTO;
import lombok.Data;

import java.util.List;

@Data
public class CoursesDTO {
    private Long id;
    private String name;
    private String description;
    List<StudentsDTO> students;
}
