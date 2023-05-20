package com.example.backend_jenkins_app.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class JenkinsTestController {
   @RequestMapping("/test")
   public String index() {

      return " Testtttttttttt pt ";
   }

}
