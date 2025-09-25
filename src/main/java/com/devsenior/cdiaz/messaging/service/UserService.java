package com.devsenior.cdiaz.messaging.service;

import java.util.List;

import com.devsenior.cdiaz.messaging.model.dto.UserRequest;
import com.devsenior.cdiaz.messaging.model.dto.UserResponse;

public interface UserService {
    List<UserResponse> getAll();

    UserResponse getByUsername(String username);

    UserResponse create(UserRequest userInfo);

    UserResponse update(String username, UserRequest userInfo);

    void delete(String username);
}
