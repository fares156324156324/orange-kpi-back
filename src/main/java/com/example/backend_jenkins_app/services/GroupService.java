package com.example.backend_jenkins_app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend_jenkins_app.models.Group;
import com.example.backend_jenkins_app.repositories.GroupRepository;

@Service
public class GroupService implements IGroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public Group addGroup(Group group) {
        return groupRepository.save(group);
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
}
