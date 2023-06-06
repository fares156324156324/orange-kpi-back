package com.example.backend_jenkins_app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.backend_jenkins_app.models.Group;
import com.example.backend_jenkins_app.services.IGroupService;

@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private IGroupService groupservice;
    @PostMapping
    public Group creategroup(@RequestParam Group.GroupName groupname) {
        Group group = new Group(groupname);
        return groupservice.addGroup(group);
    }



    @GetMapping("/getAll")
    public List<Group> getAllgroups() {
        return groupservice.getAllGroups();
    }

    @GetMapping("get/{id}")
    public Group getgroupById(@PathVariable int id) {
        
        return groupservice.getGroupById(id);
    }

    @DeleteMapping("delete/{id}")
    public void deletegroup(@PathVariable int id) {
        groupservice.deleteGroup(id);
    }
    
    @DeleteMapping("delete/{groupName}")
    public void deleteGroupByGroupName(@PathVariable String groupName) {
        groupservice.deleteByGroupName(groupName);
    }
}
