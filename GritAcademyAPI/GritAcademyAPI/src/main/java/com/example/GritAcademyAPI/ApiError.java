package com.example.GritAcademyAPI;

import org.springframework.http.HttpStatus;
import java.util.HashMap;

// Class handles all error messages, returns HashMap with message and status code used in JSON response
public class ApiError {
    public static HashMap<String, String> courseIdNotFound(Long id) {
        HashMap<String, String> error = new HashMap<String, String>();
        error.put("Error message", "Could not find course with ID " + id);
        error.put("Status code", HttpStatus.NO_CONTENT.toString());
        return error;
    }

    public static HashMap<String, String> courseNameNotFound(String name) {
        HashMap<String, String> error = new HashMap<String, String>();
        error.put("Error message", "Could not find course with name " + name);
        error.put("Status code", HttpStatus.NO_CONTENT.toString());
        return error;
    }

    public static HashMap<String, String> keywordNotFound(String word) {
        HashMap<String, String> error = new HashMap<String, String>();
        error.put("Error message", "Could not find keyword " + word);
        error.put("Status code", HttpStatus.NO_CONTENT.toString());
        return error;
    }

    public static HashMap<String, String> studentIdNotFound(Long id) {
        HashMap<String, String> error = new HashMap<String, String>();
        error.put("Error message", "Could not find student with ID " + id);
        error.put("Status code", HttpStatus.NO_CONTENT.toString());
        return error;
    }

    public static HashMap<String, String> studentNameNotFound(String fname, String lname) {
        HashMap<String, String> error = new HashMap<String, String>();
        // Show error for findByFnameAndLname
        if (fname != null && lname != null)
            error.put("Error message", "Could not find student with name " + fname + " " + lname);

        // Show error for findByFname
        else if (fname != null)
            error.put("Error message", "Could not find students with first name " + fname);

        // Show error for findByLname
        else if (lname != null)
            error.put("Error message", "Could not find students with last name " + lname);

        error.put("Status code", HttpStatus.NO_CONTENT.toString());
        return error;
    }

    public static HashMap<String, String> studentTownNotFound(String town) {
        HashMap<String, String> error = new HashMap<String, String>();
        error.put("Error message", "Could not find students with town " + town);
        error.put("Status code", HttpStatus.NO_CONTENT.toString());
        return error;
    }
}