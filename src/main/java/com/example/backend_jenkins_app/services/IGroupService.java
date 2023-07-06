package com.example.backend_jenkins_app.services;

import java.util.List;

import com.example.backend_jenkins_app.models.Group;
import com.example.backend_jenkins_app.models.User;

public interface IGroupService {

    Group addGroup(Group group);

    List<Group> getAllGroups();

    Group updateGroup(Group group);

    List<User> getUsersByGroupName(Group.GroupName groupName);

    void deleteByGroupName(Group.GroupName groupName);

    Group getGroupByGroupName(Group.GroupName groupName);
}

