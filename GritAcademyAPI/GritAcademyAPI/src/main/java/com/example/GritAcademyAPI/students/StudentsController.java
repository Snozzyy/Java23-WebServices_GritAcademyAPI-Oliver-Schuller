package com.example.GritAcademyAPI.students;

import com.example.GritAcademyAPI.ApiError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentsController {
    @Autowired
    StudentsService studentsService;

    @GetMapping(value = "/students", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findAll() {
        List<StudentsDTO> students = studentsService.findAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping(value = "/students/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {
        List<StudentsDTO> students = studentsService.findById(id);
        if (students.isEmpty())
            return new ResponseEntity<>(ApiError.studentIdNotFound(id), HttpStatus.OK);

        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping(value = "/students/name", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findByFname(
            @RequestParam(value = "fname", required = false) String fname,
            @RequestParam(value = "lname", required = false) String lname) {

        List<StudentsDTO> students = studentsService.findByName(fname, lname);
        if (students.isEmpty())
            return new ResponseEntity<>(ApiError.studentNameNotFound(fname, lname), HttpStatus.OK);

        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping(value = "/students/town/{town}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findByTown(@PathVariable(value = "town") String town) {
        List<StudentsDTO> students = studentsService.findByTown(town);
        if (students.isEmpty())
            return new ResponseEntity<>(ApiError.studentTownNotFound(town), HttpStatus.OK);

        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping(value = "/create/student")
    public ResponseEntity<Object> saveStudent(
            @RequestParam(value = "fname") String fname,
            @RequestParam(value = "lname") String lname,
            @RequestParam(value = "town", required = false) String town
    ) {

        Students student = studentsService.saveStudent(fname, lname, town);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/student/{id}")
    public ResponseEntity<Object> deleteStudent(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(studentsService.deleteById(id), HttpStatus.OK);
    }
}