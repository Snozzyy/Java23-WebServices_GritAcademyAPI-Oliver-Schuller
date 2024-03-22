package com.example.GritAcademyAPI.studentsCourses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentsCoursesController {
    @Autowired
    StudentsCoursesService studentsCoursesService;

    @GetMapping(value = "/associations", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAssociations() {
        List<StudentsCourses> studentsCourses = studentsCoursesService.findAll();
        return new ResponseEntity<>(studentsCourses, HttpStatus.OK);
    }

    @GetMapping(value = "/associations/create")
    public ResponseEntity<Object> saveAssociation(
            @RequestParam(value = "student_id") Long studentId,
            @RequestParam(value = "course_id") Long courseId) {

        StudentsCourses studentsCourses = studentsCoursesService.saveAssociation(studentId, courseId);
        return new ResponseEntity<>(studentsCourses, HttpStatus.CREATED);
    }

    @GetMapping(value = "/associations/delete/{associationId}")
    public ResponseEntity<Object> deleteAssociation(@PathVariable(value = "associationId") Long associationId) {
        return new ResponseEntity<>(studentsCoursesService.deleteById(associationId), HttpStatus.OK);
    }
}
