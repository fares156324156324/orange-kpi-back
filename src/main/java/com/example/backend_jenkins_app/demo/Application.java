package com.example.backend_jenkins_app.demo;

import com.example.backend_jenkins_app.repositories.GroupRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.backend_jenkins_app.repositories.UserRepository;

@ComponentScan("com.example.backend_jenkins_app.services")
@ComponentScan("com.example.backend_jenkins_app.controllers")
@ComponentScan("com.example.backend_jenkins_app.repositories")

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, SecurityAutoConfiguration.class })
@EnableMongoRepositories(basePackageClasses = { UserRepository.class, GroupRepository.class })

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

	@RequestMapping("/test")
	public String index() {

		return " Testttttt pt ";

	}
}
