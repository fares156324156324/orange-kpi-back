package com.example.backend_jenkins_app.services;

import java.util.List;

import com.example.backend_jenkins_app.models.Group;

public interface IGroupService {

    Group addGroup(Group user);

    Group getGroupById(int id);

    List<Group> getAllGroups();

    Group updateGroup(Group group);

    void deleteGroup(int id);

    void deleteGroupByGroupname(Group.GroupName groupname);
}
      