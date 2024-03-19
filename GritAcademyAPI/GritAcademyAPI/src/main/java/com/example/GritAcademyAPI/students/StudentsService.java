package com.example.GritAcademyAPI.students;

/*
 * Service class is where Business Logic resides
 * Her data manipulation happens. All data formatting and processing
 * happens here. Communicates with a Repository class for data
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsService {
    @Autowired
    StudentsRepository studentsRepository;

    List<Students> getStudents(){
        return studentsRepository.findAll();
    }
}
