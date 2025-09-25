package com.devsenior.cdiaz.messaging.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.cdiaz.messaging.model.dto.UserRequest;
import com.devsenior.cdiaz.messaging.model.dto.UserResponse;
import com.devsenior.cdiaz.messaging.service.UserService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {
    
    private final UserService userService;

    @GetMapping
    public List<UserResponse> getAllUsers() {
        return userService.getAll();
    }

    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest userRequest) {
        return userService.create(userRequest);
    }

    @PutMapping("/{username}")
    public UserResponse updateUser(@PathVariable String username, @RequestBody UserRequest userRequest) {
        return userService.update(username, userRequest);
    }

    @DeleteMapping("/{username}")
    public void deleteUser(@PathVariable String username) {
        userService.delete(username);
    }


}
