package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class StudentController {

    static ArrayList<Student> studentArrayList = new ArrayList<>();

    @PostMapping("/students")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        studentArrayList.add(student);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<Student>  deleteStudent(@PathVariable int id){
        studentArrayList.remove(id-1);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/students")
    public ResponseEntity<ArrayList<Student>> getStudents(@RequestParam(value = "gender",required = false) String gender) {
        if (gender.equals("")){
            return  ResponseEntity.ok().body(studentArrayList);
        }
        else {
            ArrayList<Student> students = new ArrayList<>();
            for (Student student : studentArrayList) {
                if (student.getGender().equals(gender))
                    students.add(student);
            }

            return ResponseEntity.ok().body(students);

        }
    }
}
