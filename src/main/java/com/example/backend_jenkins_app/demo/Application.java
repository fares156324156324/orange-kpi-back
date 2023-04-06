package com.example.backend_jenkins_app.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend_jenkins_app.models.User;
import com.example.backend_jenkins_app.repositories.UserRepository;

@SpringBootApplication
@RestController
@RequestMapping("/user")

public class Application {
	@Autowired
	private UserRepository repo;
	public User saveuser(@RequestBody User user){
		return repo.save(user);

	}
	@GetMapping
	public List<User> getUsers(){
		return repo.findAll();
	}
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
