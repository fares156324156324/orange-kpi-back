package com.example.backend_jenkins_app.services;

import java.util.List;

import com.example.backend_jenkins_app.models.Group;
import com.example.backend_jenkins_app.models.User;

public interface IGroupService {

    Group addGroup(Group user);

    List<Group> getAllGroups();

    Group updateGroup(Group group);
    public List<User> getUsersByGroupName(Group.GroupName groupName) ;
            public void deleteByGroupName(Group.GroupName groupName) ;
    public Group getGroupByGroupName(Group.GroupName groupName);
}
      