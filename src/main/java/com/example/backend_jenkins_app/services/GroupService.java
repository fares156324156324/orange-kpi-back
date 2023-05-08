package com.example.backend_jenkins_app.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend_jenkins_app.models.Group;
import com.example.backend_jenkins_app.repositories.GroupRepository;

@Service
public class GroupService implements IGroupService {
    @Autowired
    private GroupRepository groupRepository;

    @Override
    public Group AddGroup(Group group) {
        return groupRepository.save(group);

    }

    @Override
    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    @Override
    public Group getGroupById(int id) {
        return groupRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("group not found with id " + id));

    }

    @Override
    public void DeleteGroup(int id) {
        groupRepository.deleteById(id);
    }
}