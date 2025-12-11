package com.example.davideshop.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class homeController {
    @GetMapping("/")
    public String home() {
        return "ffefe";
    }
    
}
