package com.example.backend_jenkins_app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend_jenkins_app.models.Group;
import com.example.backend_jenkins_app.models.User;
import com.example.backend_jenkins_app.repositories.GroupRepository;
import com.mongodb.DuplicateKeyException;

@Service
public class GroupService implements IGroupService {

    @Autowired
    private GroupRepository groupRepository;

    public Group addGroup(Group group) {
        try {
            return groupRepository.save(group);
        } catch (DuplicateKeyException e) {
            // Handle the duplicate key exception
            throw new IllegalArgumentException("Group already exists");
        }
    }

    @Override
    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    @Override
    public Group updateGroup(Group group) {
        return groupRepository.save(group);
    }


    @Override
    public void deleteByGroupName(Group.GroupName groupName) {
        groupRepository.deleteByGroupname(groupName);
    }

    @Override
    public Group getGroupByGroupName(Group.GroupName groupName) {
        return groupRepository.findByGroupname(groupName);
    }
     public List<User> getUsersByGroupName(Group.GroupName groupName) {
        Group group = groupRepository.findByGroupname(groupName);
        if (group == null) {
            throw new IllegalArgumentException("Invalid group name");
        }
        
        return group.getUsers();
    }
}
