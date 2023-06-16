package com.example.backend_jenkins_app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.backend_jenkins_app.models.User;
import com.example.backend_jenkins_app.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service

public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);


    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User authenticateUser(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }
    @Override
    public User getUserByNameAndPassword(String name, String password) throws UsernameNotFoundException {
      User user = userRepository.findByEmailAndPassword(name, password);
      if(user == null){
         throw new UsernameNotFoundException("Invalid  email and password");
      }
      return user;
    }
}

    
