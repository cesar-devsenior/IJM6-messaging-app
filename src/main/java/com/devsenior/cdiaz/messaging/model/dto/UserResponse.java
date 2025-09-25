package com.devsenior.cdiaz.messaging.model.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponse {
    private String username;
    private String fullName;
    private String email;
    private String phone;
    private Set<String> intereses;
    private String profile;
    private String school;
    private String program;
    private String company;
    private String position;
    private String seniority;
}
