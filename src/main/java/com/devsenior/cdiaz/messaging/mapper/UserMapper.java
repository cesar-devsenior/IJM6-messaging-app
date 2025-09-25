package com.devsenior.cdiaz.messaging.mapper;

import com.devsenior.cdiaz.messaging.model.document.User;
import com.devsenior.cdiaz.messaging.model.dto.UserRequest;
import com.devsenior.cdiaz.messaging.model.dto.UserResponse;

public class UserMapper {

    public User toDocument(UserRequest request) {
        var response = new User();
        response.setUsername(request.getUsername());
        response.setPassword(request.getPassword());
        response.setFullName(request.getFullName());
        response.setEmail(request.getEmail());
        response.setPhone(request.getPhone());
        response.setActive(Boolean.TRUE);
        response.setIntereses(request.getIntereses());
        User.Profile profile = null;
        if(request.getSchool() != null) {
            profile = new User.Student();
            ((User.Student)profile).setSchool(request.getSchool());
            ((User.Student)profile).setProgram(request.getProgram());
        } else {
            profile = new User.Employee();
            ((User.Employee)profile).setCompany(request.getCompany());
            ((User.Employee)profile).setPosition(request.getPosition());
            ((User.Employee)profile).setSeniority(request.getSeniority());
        }
        response.setProfile(profile);

        return response;
    }

    public UserResponse toResponse(User user) {
        var isStudent = (user.getProfile() instanceof User.Student); 
        var profile = (isStudent ? "Student" : "Employee");

        var response = new UserResponse(
            user.getUsername(),
            user.getFullName(),
            user.getEmail(),
            user.getPhone(),
            user.getIntereses(),
            profile,
            isStudent ? ((User.Student)user.getProfile()).getSchool() : null,
            isStudent ? ((User.Student)user.getProfile()).getProgram() : null,
            !isStudent ? ((User.Employee)user.getProfile()).getCompany() : null,
            !isStudent ? ((User.Employee)user.getProfile()).getPosition() : null,
            !isStudent ? ((User.Employee)user.getProfile()).getSeniority() : null
        );
        
        return response;
    }
}

