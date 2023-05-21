package com.example.backend_jenkins_app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.backend_jenkins_app.models.Group;
import com.example.backend_jenkins_app.services.GroupService;

@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private GroupService groupservice;

    @PostMapping
    public Group creategroup(@RequestBody Group group) {
        return groupservice.addGroup(group);
    }

    @GetMapping("/getAll")
    public List<Group> getAllgroups() {
        return groupservice.getAllGroups();
    }

    @GetMapping("/{id}")
    public Group getgroupById(@PathVariable int id) {
        return groupservice.getGroupById(id);
    }

    @DeleteMapping("/{id}")
    public void deletegroup(@PathVariable int id) {
        groupservice.deleteGroup(id);
    }
}
