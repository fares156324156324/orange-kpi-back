package com.example.backend_jenkins_app.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend_jenkins_app.models.Group;
import com.example.backend_jenkins_app.models.User;
import com.example.backend_jenkins_app.repositories.GroupRepository;
import com.example.backend_jenkins_app.services.IGroupService;
import com.example.backend_jenkins_app.services.IUserService;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private GroupRepository groupRepository;
    @Autowired

    private IGroupService groupService;
    @Autowired

    private IUserService userService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        String email = user.getEmail();
        User existingUser = userService.getUserByEmail(email);
        if (existingUser != null) {
            throw new IllegalArgumentException("User already exists");
        }
    
        Group group = groupRepository.findByGroupname(user.getGroup().getGroupname());
        if (group == null) {
            // Handle invalid group name
            throw new IllegalArgumentException("Invalid group name");
        }
        
        // Set the group for the user
        user.setGroup(group);
    
        // Save the user to the database
        User res = userService.addUser(user);
    
        // Update the group's list of users
        List<User> users = new ArrayList<>(group.getUsers()); // Create a mutable copy of the list
        users.add(res);
        group.setUsers(users);
        groupRepository.save(group);
    
        return res;
    }
    

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @GetMapping("/getAll")

    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
}
