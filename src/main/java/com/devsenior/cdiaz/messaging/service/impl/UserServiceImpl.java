package com.devsenior.cdiaz.messaging.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devsenior.cdiaz.messaging.exception.ValidationException;
import com.devsenior.cdiaz.messaging.exception.NotFoundException;
import com.devsenior.cdiaz.messaging.mapper.UserMapper;
import com.devsenior.cdiaz.messaging.model.dto.UserRequest;
import com.devsenior.cdiaz.messaging.model.dto.UserResponse;
import com.devsenior.cdiaz.messaging.repository.UserRepository;
import com.devsenior.cdiaz.messaging.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserResponse> getAll() {
        return userRepository.findAll().stream()
                .filter(u -> u.getActive())
                .map(userMapper::toResponse)
                .toList();
    }

    @Override
    public UserResponse getByUsername(String username) {
        return userRepository.findById(username)
                .map(userMapper::toResponse)
                .orElseThrow(() -> new NotFoundException("El usuario no existe"));
    }

    @Override
    public UserResponse create(UserRequest userInfo) {
        // Validar si los campos obligatorios estan llenos
        if (userInfo.getUsername() == null || userInfo.getUsername().isBlank()) {
            throw new ValidationException(null);
        }
        // ...

        var user = userMapper.toDocument(userInfo);
        user = userRepository.save(user);

        return userMapper.toResponse(user);
    }

    @Override
    public UserResponse update(String username, UserRequest userInfo) {
        // Validar si los campos obligatorios estan llenos
        if (userInfo.getUsername() == null || userInfo.getUsername().isBlank()) {
            throw new ValidationException(null);
        }
        // ...
        if (!userRepository.existsById(username)) {
            throw new NotFoundException("El usuario '" + username + "' no existe");
        }

        var user = userMapper.toDocument(userInfo);
        user.setUsername(username);
        user = userRepository.save(user);

        return userMapper.toResponse(user);
    }

    @Override
    public void delete(String username) {
        if (!userRepository.existsById(username)) {
            throw new NotFoundException("El usuario '" + username + "' no existe");
        }

        userRepository.deleteById(username);
    }

}
