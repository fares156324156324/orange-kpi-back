package com.example.backend_jenkins_app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.backend_jenkins_app.models.Group;

public interface GroupRepository extends MongoRepository<Group, String> {

    void deleteByGroupname(Group.GroupName groupName);
    Group findByGroupname(Group.GroupName groupName);

}
