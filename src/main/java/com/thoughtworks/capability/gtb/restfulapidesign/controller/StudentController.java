package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.dto.Groups;
import com.thoughtworks.capability.gtb.restfulapidesign.dto.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.service.GroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class StudentController {

    static ArrayList<Student> studentArrayList = new ArrayList<>();


    private final GroupService groupService;

    public StudentController(GroupService groupService) {
        this.groupService = groupService;
    }


    @PostMapping("/students")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        studentArrayList.add(student);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable int id) {
        studentArrayList.remove(id - 1);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/students")
    public ResponseEntity<ArrayList<Student>> getStudents(@RequestParam(value = "gender", required = false) String gender) {
        if (gender == null) {
            return ResponseEntity.ok().body(studentArrayList);
        } else {
            ArrayList<Student> students = new ArrayList<>();
            for (Student student : studentArrayList) {
                if (student.getGender().equals(gender))
                    students.add(student);
            }
            return ResponseEntity.ok().body(students);

        }
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getSingleStudent(@PathVariable int id) {
        for (Student student : studentArrayList) {
            if (student.getId() == id) {
                return ResponseEntity.ok().body(student);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudentInformation(@PathVariable int id, @RequestBody Student newStudent) {
        for (Student oldStudent : studentArrayList) {
            if (oldStudent.getId() == id) {
                oldStudent.setName(newStudent.getName());
                oldStudent.setGender(newStudent.getGender());
                oldStudent.setNote(newStudent.getNote());
            }
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/students/split")
    public ResponseEntity<Groups> splitStudent() {
        return groupService.groupStudents(studentArrayList);
    }

    @PatchMapping("/groups")
    public ResponseEntity<Group> updateGroupName(@RequestParam String group, String name) {
        return groupService.updateGroupsName(group, name);
    }

    @GetMapping("/groups")
    public ResponseEntity<Groups> getGroups() {
        return groupService.getGroups();
    }
}
