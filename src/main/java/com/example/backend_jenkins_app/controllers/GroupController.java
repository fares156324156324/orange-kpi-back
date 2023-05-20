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

    @GetMapping("/getAll")
    public List<Group> getAllUsers() {
        return groupservice.getAllGroups();

    }

    @GetMapping("/getuser/{id}")
    public ResponseEntity<Group> getGroupById(@PathVariable("id") int id) {
        Group group = groupservice.getGroupById(id);
        if (group == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(group);
    }

    @PostMapping
    public void createGroup(@RequestBody Group group) {
        groupservice.AddGroup(group);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteGroup(@PathVariable int id) {
        groupservice.DeleteGroup(id);
    }

}
