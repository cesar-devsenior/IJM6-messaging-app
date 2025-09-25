package com.devsenior.cdiaz.messaging.model.dto;

import java.util.Set;

import lombok.Data;

@Data
public class UserRequest {
    private String username;
    private String password;
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
