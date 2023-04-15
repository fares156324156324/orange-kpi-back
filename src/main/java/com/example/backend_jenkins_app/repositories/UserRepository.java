package com.example.backend_jenkins_app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.backend_jenkins_app.models.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, Integer> {

}