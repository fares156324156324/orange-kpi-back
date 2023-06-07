package com.example.backend_jenkins_app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.backend_jenkins_app.models.Group;
import com.example.backend_jenkins_app.services.IGroupService;
import com.mongodb.DuplicateKeyException;

@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private IGroupService groupservice;

    
    @PostMapping
    public ResponseEntity<Object> createGroup(@RequestBody Group group) {
        try {
            Group createdGroup = groupservice.addGroup(group);
            return ResponseEntity.ok(createdGroup);
        } catch (DuplicateKeyException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Group with the same name already exists");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while processing the request");
        }
    }
    
    @GetMapping("/getAll")
    public List<Group> getAllgroups() {
        return groupservice.getAllGroups();
    }

    @GetMapping("/getByName/{groupName}")
    public Group getGroupByGroupName(@PathVariable Group.GroupName groupName) {
        return groupservice.getGroupByGroupName(groupName);
    }

    

    @DeleteMapping("/deleteByGroupName/{groupName}")
    public void deleteGroupByGroupName(@PathVariable Group.GroupName groupName) {
        groupservice.deleteByGroupName(groupName);
    }
    
}
