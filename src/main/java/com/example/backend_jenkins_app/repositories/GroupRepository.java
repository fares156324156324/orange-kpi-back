package com.example.backend_jenkins_app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.backend_jenkins_app.models.Group;

@Repository

public interface GroupRepository extends MongoRepository<Group, Integer> {

}
