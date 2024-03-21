package com.example.GritAcademyAPI.courses;

import com.example.GritAcademyAPI.ApiError;
import com.example.GritAcademyAPI.students.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CoursesController {
    @Autowired
    CoursesService coursesService;

    @GetMapping(value = "/courses", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getCourses(){
        List<CoursesDTO> courses = coursesService.findAll();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @GetMapping(value = "/courses/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {
        List<CoursesDTO> course = coursesService.findById(id);
        // If response is empty return error message
        if (course.isEmpty()) {
            return new ResponseEntity<>(ApiError.courseIdNotFound(id), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @GetMapping(value = "/courses/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findByName(@PathVariable(value = "name") String name) {
        List<CoursesDTO> course = coursesService.findByName(name);
        // If response is empty return error message
        if (course.isEmpty()) {
            return new ResponseEntity<>(ApiError.courseNameNotFound(name), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @GetMapping(value = "/courses/name-contains/{keyword}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findByNameContaining(@PathVariable(value = "keyword") String word) {
        List<CoursesDTO> course = coursesService.findByNameContaining(word);
        // If response is empty return error message
        if (course.isEmpty()) {
            return new ResponseEntity<>(ApiError.keywordNotFound(word), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @GetMapping(value = "/courses/description-contains/{keyword}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findByDescriptionContaining(@PathVariable(value = "keyword") String word) {
        List<CoursesDTO> course = coursesService.findByDescriptionContaining(word);
        // If response is empty return error message
        if (course.isEmpty()) {
            return new ResponseEntity<>(ApiError.keywordNotFound(word), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @PostMapping(value = "/create/course")
    public ResponseEntity<Object> saveCourse(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "description", required = false) String description
    ) {

        Courses course = coursesService.saveCourse(name, description);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/course/{id}")
    public ResponseEntity<Object> deleteCourse(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(coursesService.deleteById(id), HttpStatus.OK);
    }
}