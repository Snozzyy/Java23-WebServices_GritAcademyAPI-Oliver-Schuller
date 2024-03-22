package com.example.GritAcademyAPI.studentsCourses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class StudentsCoursesService {
    @Autowired
    StudentsCoursesRepository studentsCoursesRepository;

    public List<StudentsCourses> findAll() {
        return studentsCoursesRepository.findAll();
    }

    public StudentsCourses saveAssociation(Long studentId, Long courseId) {
        StudentsCourses studentsCourses = new StudentsCourses();
        studentsCourses.setStudentsId(studentId);
        studentsCourses.setCoursesId(courseId);

        return studentsCoursesRepository.save(studentsCourses);
    }

    public HashMap<String, String> deleteById(Long associationId) {
        studentsCoursesRepository.deleteById(Math.toIntExact(associationId));
        HashMap<String, String> message = new HashMap<>();
        message.put("Message", "Association with id " + associationId + " removed");
        return message;
    }
}
