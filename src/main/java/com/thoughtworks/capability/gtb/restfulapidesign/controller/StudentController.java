package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class StudentController {

    static ArrayList<Student> studentArrayList = new ArrayList<>();

    @PostMapping("/students")
    public ResponseEntity<Student> addStudents(@RequestBody Student student){
        studentArrayList.add(student);
        return ResponseEntity.ok().build();
    }

}
