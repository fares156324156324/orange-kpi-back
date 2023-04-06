package com.example.backend_jenkins_app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.backend_jenkins_app.models.User;

public interface UserRepository extends MongoRepository<User,Integer>{
    
}