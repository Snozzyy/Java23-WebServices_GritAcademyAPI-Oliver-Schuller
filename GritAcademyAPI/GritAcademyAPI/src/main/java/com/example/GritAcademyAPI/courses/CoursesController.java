package com.example.GritAcademyAPI.courses;

import com.example.GritAcademyAPI.ApiError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
            return new ResponseEntity<>(ApiError.noIdFound(id), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @GetMapping(value = "/courses/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findByName(@PathVariable(value = "name") String name) {
        List<CoursesDTO> course = coursesService.findByName(name);
        // If response is empty return error message
        if (course.isEmpty()) {
            return new ResponseEntity<>(ApiError.noNameFound(name), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @GetMapping(value = "/courses/name-contains/{keyword}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findByNameContaining(@PathVariable(value = "keyword") String word) {
        List<CoursesDTO> course = coursesService.findByNameContaining(word);
        // If response is empty return error message
        if (course.isEmpty()) {
            return new ResponseEntity<>(ApiError.noKeywordFound(word), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @GetMapping(value = "/courses/description-contains/{keyword}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findByDescriptionContaining(@PathVariable(value = "keyword") String word) {
        List<CoursesDTO> course = coursesService.findByDescriptionContaining(word);
        // If response is empty return error message
        if (course.isEmpty()) {
            return new ResponseEntity<>(ApiError.noKeywordFound(word), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(course, HttpStatus.OK);
    }
}