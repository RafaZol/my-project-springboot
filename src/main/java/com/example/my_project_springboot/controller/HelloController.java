package com.example.my_project_springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Controlador para manejar solicitações HTTP

@RestController
@RequestMapping("/api")
public class HelloController {
    
@GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

}
