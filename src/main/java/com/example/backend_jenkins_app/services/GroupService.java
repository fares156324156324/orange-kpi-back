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
    public Group getGroupById(int id) {
        return groupRepository.findById(id).orElse(null);
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
    public void deleteGroup(int id) {
        groupRepository.deleteById(id);

    }

    @Override

    public void deleteGroupByGroupname(Group.GroupName groupname) {
        groupRepository.deleteByGroupname(groupname);
    }




}