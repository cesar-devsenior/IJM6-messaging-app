package com.devsenior.cdiaz.messaging.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.devsenior.cdiaz.messaging.model.document.User;


public interface UserRepository extends MongoRepository<User, String> {
    
    Optional<User> findByEmail(String email);
}
