package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.dto.Groups;
import com.thoughtworks.capability.gtb.restfulapidesign.dto.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Service
public class GroupService {

    static Group group1 = Group.builder().id(1).name("team 1").students(new ArrayList<Student>()).build();
    static Group group2 = Group.builder().id(2).name("team 2").students(new ArrayList<Student>()).build();
    static Group group3 = Group.builder().id(3).name("team 3").students(new ArrayList<Student>()).build();
    static Group group4 = Group.builder().id(4).name("team 4").students(new ArrayList<Student>()).build();
    static Group group5 = Group.builder().id(5).name("team 5").students(new ArrayList<Student>()).build();
    static Group group6 = Group.builder().id(6).name("team 6").students(new ArrayList<Student>()).build();


    public ResponseEntity<Groups> groupStudents(ArrayList<Student> studentArrayList) {

        Collections.shuffle(studentArrayList);
        for (int i = 0; i < studentArrayList.size(); i++) {
            switch (i % 6) {
                case 0 : group1.getStudents().add(studentArrayList.get(i));break;
                case 1 : group2.getStudents().add(studentArrayList.get(i));break;
                case 2 : group3.getStudents().add(studentArrayList.get(i));break;
                case 3 : group4.getStudents().add(studentArrayList.get(i));break;
                case 4 : group5.getStudents().add(studentArrayList.get(i));break;
                case 5 : group6.getStudents().add(studentArrayList.get(i));break;
            }

        }
        Groups groups = Groups.builder()
                .group1(group1)
                .group2(group2)
                .group3(group3)
                .group4(group4)
                .group5(group5)
                .group6(group6)
                .build();
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Group> updateGroupsName(String group, String name) {
        switch (group) {
            case "group1" : group1.setName(name);break;
            case "group2" : group2.setName(name);break;
            case "group3" : group3.setName(name);break;
            case "group4" : group4.setName(name);break;
            case "group5" : group5.setName(name);break;
            case "group6" : group6.setName(name);break;
        }
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Groups> getGroups(){
        Groups groups = Groups.builder()
                .group1(group1)
                .group2(group2)
                .group3(group3)
                .group4(group4)
                .group5(group5)
                .group6(group6)
                .build();
        return ResponseEntity.ok().body(groups);
    }
}
