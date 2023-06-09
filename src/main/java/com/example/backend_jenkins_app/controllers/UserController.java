package com.example.backend_jenkins_app.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public ResponseEntity<String> createUser(@RequestBody User user) {
    try {
        String email = user.getEmail();
        User existingUser = userService.getUserByEmail(email);
        if (existingUser != null) {
            throw new IllegalArgumentException("User already exists");
        }
    
        Group group = groupRepository.findByGroupname(user.getGroup().getGroupname());
        if (group == null) {
            throw new IllegalArgumentException("Invalid group name");
        }
        
        user.setGroup(group);
    
        User res = userService.addUser(user);
    
        List<User> users = new ArrayList<>(group.getUsers()); // Create a mutable copy of the list
        users.add(res);
        group.setUsers(users);
        groupRepository.save(group);
    
        return ResponseEntity.status(HttpStatus.CREATED).body("User added with success");
    } catch (IllegalArgumentException e) {
        // User already exists or invalid group name
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    } catch (Exception e) {
        // Other exceptions
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create user");
    }
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
