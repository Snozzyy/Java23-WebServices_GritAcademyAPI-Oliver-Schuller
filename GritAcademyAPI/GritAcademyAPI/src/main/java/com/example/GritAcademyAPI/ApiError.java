package com.example.GritAcademyAPI;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Class handles all error messages, returns HashMap with message and status code used in JSON response
public class ApiError {
    public static HashMap<String, String> noIdFound(Long id) {
        HashMap<String, String> error = new HashMap<String, String>();
        error.put("Error message", "Could not find ID " + id);
        error.put("Status code", HttpStatus.NO_CONTENT.toString());
        return error;
    }

    public static HashMap<String, String> noNameFound(String name) {
        HashMap<String, String> error = new HashMap<String, String>();
        error.put("Error message", "Could not find name " + name);
        error.put("Status code", HttpStatus.NO_CONTENT.toString());
        return error;
    }

    public static HashMap<String, String> noKeywordFound(String word) {
        HashMap<String, String> error = new HashMap<String, String>();
        error.put("Error message", "Could not find keyword " + word);
        error.put("Status code", HttpStatus.NO_CONTENT.toString());
        return error;
    }
}

