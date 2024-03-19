package com.example.GritAcademyAPI.students;

import com.example.GritAcademyAPI.courses.CoursesDTO;
import lombok.Data;

import java.util.List;

@Data
public class StudentsDTO {
    private Long id;
    private String fname;
    private String lname;
    private String town;
    List<CoursesDTO> courses;
}
