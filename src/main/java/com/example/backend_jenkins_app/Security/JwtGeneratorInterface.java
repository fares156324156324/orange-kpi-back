package com.example.backend_jenkins_app.Security;

import java.util.Map;

import com.example.backend_jenkins_app.models.User;
public interface JwtGeneratorInterface {
Map<String, String> generateToken(User user);
}