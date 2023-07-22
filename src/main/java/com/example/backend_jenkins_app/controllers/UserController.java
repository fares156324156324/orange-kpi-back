package com.example.backend_jenkins_app.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend_jenkins_app.Security.JwtUtil;
import com.example.backend_jenkins_app.models.Group;
import com.example.backend_jenkins_app.models.User;
import com.example.backend_jenkins_app.repositories.GroupRepository;
import com.example.backend_jenkins_app.services.IUserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private GroupRepository groupRepository;

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
    

    @PutMapping("/{email}")
    public ResponseEntity<String> updateUserByEmail(@PathVariable String email, @RequestBody User updatedUser) {
        try {
            User user = userService.getUserByEmail(email);
            if (user == null) {
                throw new IllegalArgumentException("User not found");
            }
            
            // Update the user details
            user.setUserName(updatedUser.getUserName());
            user.setEmail(updatedUser.getEmail());
            user.setPassword(updatedUser.getPassword());
            user.setRole(updatedUser.getRole());
            
            User savedUser = userService.updateUser(user);
            
            return ResponseEntity.status(HttpStatus.OK).body("User updated successfully");
        } catch (IllegalArgumentException e) {
            // User not found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            // Other exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update user");
        }
    }
    


    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }




    @PutMapping("/{email}/group/{groupName}")
    public ResponseEntity<String> updateUserGroup(@PathVariable String email, @PathVariable String groupName) {
        try {
            User user = userService.getUserByEmail(email);
            if (user == null) {
                throw new IllegalArgumentException("User not found");
            }
            
            Group group = groupRepository.findByGroupname(Group.GroupName.valueOf(groupName.toUpperCase()));
            if (group == null) {
                throw new IllegalArgumentException("Invalid group name");
            }
            
            user.setGroup(group);
            User updatedUser = userService.updateUser(user);
            
            // Save the updated user
            userService.updateUser(updatedUser);
            
            return ResponseEntity.status(HttpStatus.OK).body("User group updated successfully");
        } catch (IllegalArgumentException e) {
            // User not found or invalid group name
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            // Other exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update user group");
        }
    }
    


@CrossOrigin(origins = "http://localhost:4200")
@PostMapping("/login")
public ResponseEntity<String> login(@RequestBody User user) {
    String email = user.getEmail();
    String password = user.getPassword();

    User authenticatedUser = userService.authenticateUser(email, password);
    if (authenticatedUser != null) {
        // User authentication successful
        // Generate a JWT token for the user
        String token = jwtUtil.generateToken(email);
        return ResponseEntity.ok(token);
    } else {
        // User authentication failed
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }
}

}

