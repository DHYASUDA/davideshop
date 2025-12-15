package com.example.davideshop.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.davideshop.dto.userUpdateRequest;
import com.example.davideshop.model.userEntity;
import com.example.davideshop.repository.userRepo;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5173")
public class userController {

    private final userRepo userRepo;

    public userController(userRepo userRepo) {
        this.userRepo = userRepo;
    }

    @PutMapping("/update")
    public userEntity updateUser(@RequestBody userUpdateRequest request) {
        System.out.println("updateUser email = " + request.getEmail());
        System.out.println("updateUser fullName = " + request.getFullName());

        Optional<userEntity> optionalUser = userRepo.findById(request.getId());

        if (optionalUser.isEmpty()) {
            throw new IllegalArgumentException("User not found");
        }

        userEntity user = optionalUser.get();

        // only update name for now
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());

        return userRepo.save(user);
    }
}
