package com.thoughtworks.capability.gtb.restfulapidesign.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Group {
    private int id;
    private String name;
    private String note;
    private ArrayList<Student> students;
}
