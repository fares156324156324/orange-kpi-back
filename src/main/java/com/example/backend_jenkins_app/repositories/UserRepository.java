package com.example.backend_jenkins_app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import com.example.backend_jenkins_app.models.User;
import org.springframework.stereotype.Repository;

@EnableMongoRepositories(basePackageClasses = UserRepository.class)
@Repository
public interface UserRepository extends MongoRepository<User, Integer> {
    User findByEmail(String email);
    User findByEmailAndPassword(String email, String password);

}
