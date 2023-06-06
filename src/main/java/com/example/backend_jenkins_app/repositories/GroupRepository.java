package com.example.backend_jenkins_app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;
import com.example.backend_jenkins_app.models.Group;
import com.example.backend_jenkins_app.models.Group.GroupName;

@EnableMongoRepositories(basePackageClasses = GroupRepository.class)

@Repository

public interface GroupRepository extends MongoRepository<Group, Integer> {
    

}
