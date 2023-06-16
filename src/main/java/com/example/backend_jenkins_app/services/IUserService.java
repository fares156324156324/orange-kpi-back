package com.example.backend_jenkins_app.services;

import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.backend_jenkins_app.models.User;

public interface IUserService {

    User addUser(User user);

    User getUserById(int id);

    List<User> getAllUsers();

    User updateUser(User user);

    void deleteUser(int id);

    public User getUserByEmail(String email) ;
    
    User authenticateUser(String email, String password);
    public User getUserByNameAndPassword(String name, String password) throws UsernameNotFoundException;


}