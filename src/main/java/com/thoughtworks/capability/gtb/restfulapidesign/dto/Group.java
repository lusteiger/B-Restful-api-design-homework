package com.thoughtworks.capability.gtb.restfulapidesign.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Group {
    private int id;
    private String name;
    private String note;
}
