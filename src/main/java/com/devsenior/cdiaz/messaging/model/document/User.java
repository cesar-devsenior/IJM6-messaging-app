package com.devsenior.cdiaz.messaging.model.document;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class User {
    
    @Id
    private String username;

    private String password;
    private String fullName;
    private String email;
    private String phone;
    private Boolean active;
    private Set<String> intereses;
    private Profile profile;

    public static interface Profile {
    }

    @Data
    public static class Student implements Profile {
        private String school;
        private String program;
    }

    @Data
    public static class Employee implements Profile {
        private String company;
        private String position;
        private String seniority;
    }

}
