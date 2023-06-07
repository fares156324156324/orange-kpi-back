package com.example.backend_jenkins_app.services;

import java.util.List;

import com.example.backend_jenkins_app.models.Group;

public interface IGroupService {

    Group addGroup(Group user);

    List<Group> getAllGroups();

    Group updateGroup(Group group);

    public void deleteByGroupName(Group.GroupName groupName) ;
    public Group getGroupByGroupName(Group.GroupName groupName);
}
      