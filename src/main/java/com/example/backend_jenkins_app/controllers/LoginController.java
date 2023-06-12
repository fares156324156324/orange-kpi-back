package com.example.backend_jenkins_app.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.backend_jenkins_app.Security.JWTUtil;
import com.example.backend_jenkins_app.models.User;
import com.example.backend_jenkins_app.repositories.GroupRepository;
import com.example.backend_jenkins_app.services.IGroupService;
import com.example.backend_jenkins_app.services.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




@RestController
@RequestMapping("/login")

public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private GroupRepository groupRepository;
    @Autowired

    private IGroupService groupService;
    @Autowired

    private IUserService userService;

    


    @PostMapping
    public ResponseEntity<String> login(@RequestBody User user) {
        String email = user.getEmail();
        String password = user.getPassword();
        
        logger.info("Login request received for email: {}", email); // Log the email
        
        User authenticatedUser = userService.authenticateUser(email, password);
        logger.info("Authenticated User: {}", authenticatedUser); // Log the authenticatedUser
        
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
