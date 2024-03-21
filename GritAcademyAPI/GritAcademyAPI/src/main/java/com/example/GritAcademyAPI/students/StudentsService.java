package com.example.GritAcademyAPI.students;

import com.example.GritAcademyAPI.courses.Courses;
import com.example.GritAcademyAPI.courses.CoursesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentsService {
    @Autowired
    StudentsRepository studentsRepository;

    public List<StudentsDTO> findAll() {
        return studentsRepository.findAll().stream().map(this::studentsMapToDTO).collect(Collectors.toList());
    }

    public List<StudentsDTO> findById(Long id) {
        Optional<Students> students = studentsRepository.findById(Math.toIntExact(id));
        return students.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public List<StudentsDTO> findByName(String fname, String lname) {
        List<Students> students = null;
        if (fname != null && lname != null) {
            students = studentsRepository.findByFnameAndLname(fname, lname);
        } else if (fname != null) {
            students = studentsRepository.findByFname(fname);
        } else if (lname != null) {
            students = studentsRepository.findByLname(lname);
        }
        return students.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public List<StudentsDTO> findByTown(String town) {
        List<Students> students = studentsRepository.findByTown(town);
        return students.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public Students saveStudent(String fname, String lname, String town) {
        Students students = new Students();
        students.setFname(fname);
        students.setLname(lname);
        students.setTown(town);

        return studentsRepository.save(students);
    }

    public HashMap<String, String> deleteById(Long id) {
        studentsRepository.deleteById(Math.toIntExact(id));
        HashMap<String, String> message = new HashMap<>();
        message.put("Message", "User with ID " + id + " removed");
        return message;
    }

    private StudentsDTO mapToDTO(Students students) {
        StudentsDTO dto = new StudentsDTO();
        dto.setId(students.getId());
        dto.setFname(students.getFname());
        dto.setLname(students.getLname());
        dto.setTown(students.getTown());
        dto.setCourses(students.getCourses().stream().map(this::mapToDTO).collect(Collectors.toList()));
        return dto;
    }

    private StudentsDTO studentsMapToDTO(Students students) {
        StudentsDTO dto = new StudentsDTO();
        dto.setId(students.getId());
        dto.setFname(students.getFname());
        dto.setLname(students.getLname());
        dto.setTown(students.getTown());
        return dto;
    }

    private CoursesDTO mapToDTO(Courses courses) {
        CoursesDTO dto = new CoursesDTO();
        dto.setId(courses.getId());
        dto.setName(courses.getName());
        dto.setDescription(courses.getDescription());

        return dto;
    }
}
