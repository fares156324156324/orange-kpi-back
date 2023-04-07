package com.example.backend_jenkins_app.services;

import java.util.List;

import com.example.backend_jenkins_app.models.Group;

public interface IGroupService {
    
    public Group AddGroup(Group group);
    
    public List<Group> getAllGroups(); 
    
    public Group getGroupById(int id);
    
	public void DeleteGroup(int id);


}