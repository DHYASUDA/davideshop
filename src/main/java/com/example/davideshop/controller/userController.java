package com.example.davideshop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.davideshop.dto.userUpdateRequest;
import com.example.davideshop.model.userEntity;
import com.example.davideshop.service.userService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5173")
public class userController {
    private final userService userService;

    public userController(userService userService) {
        this.userService = userService;
    }

    @PutMapping("/updateAddress")
    public ResponseEntity<userEntity> updateUserAddress(@RequestBody userUpdateRequest request) {
        userEntity user = userService.updateUserAdress(request);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/update")
    public ResponseEntity<userEntity> updateUserInfo(@RequestBody userUpdateRequest request) {
        userEntity user = userService.updateUser(request);
        return ResponseEntity.ok(user);
    }
}
