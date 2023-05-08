package com.example.backend_jenkins_app.services;

import java.util.List;

import com.example.backend_jenkins_app.models.User;

public interface IUserService {

    public User AddUser(User user);

    public List<User> getAllUsers();

    public User getUserById(int id);

    public void DeleteUser(int id);

}