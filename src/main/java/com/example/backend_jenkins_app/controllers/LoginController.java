package com.example.backend_jenkins_app.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.backend_jenkins_app.Security.JWTUtil;
import com.example.backend_jenkins_app.models.User;
import com.example.backend_jenkins_app.repositories.GroupRepository;
import com.example.backend_jenkins_app.services.IGroupService;
import com.example.backend_jenkins_app.services.IUserService;



@RequestMapping("/login")

public class LoginController {
    
    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private GroupRepository groupRepository;
    @Autowired

    private IGroupService groupService;
    @Autowired

    private IUserService userService;

    


    
    
public ResponseEntity<String> login(@RequestBody User user) {
    String email = user.getEmail();
    String password = user.getPassword();
    
    User authenticatedUser = userService.authenticateUser(email, password);
    if (authenticatedUser != null) {
        // User authentication successful
        // Generate a JWT token
        String token = jwtUtil.generateToken(email);
        
        // Return the JWT token in the response body
        return ResponseEntity.ok(token);
    } else {
        // User authentication failed
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }
}


}
