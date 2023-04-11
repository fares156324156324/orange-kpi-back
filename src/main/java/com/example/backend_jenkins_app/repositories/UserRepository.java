package com.example.backend_jenkins_app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.backend_jenkins_app.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}