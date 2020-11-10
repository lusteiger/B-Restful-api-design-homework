package com.thoughtworks.capability.gtb.restfulapidesign.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Groups {
    private   Group group1;
    private   Group group2;
    private   Group group3;
    private   Group group4;
    private   Group group5;
    private   Group group6;
}
