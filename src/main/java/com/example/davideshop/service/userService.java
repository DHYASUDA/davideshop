package com.example.davideshop.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.davideshop.dto.loginRequest;
import com.example.davideshop.dto.signUpRequest;
import com.example.davideshop.model.userEntity;
import com.example.davideshop.repository.userRepo;

@Service
public class userService {
    private final userRepo userRepo;

    public userService(userRepo userRepo) {
        this.userRepo = userRepo;
    }

    public userEntity register(signUpRequest request) {
        if (!userRepo.findByEmail(request.getEmail()).isPresent()) {
            userEntity user = new userEntity();
            user.setEmail(request.getEmail());
            user.setFullName(request.getfullName());
            user.setPassword(request.getPassword());
            return userRepo.save(user);
        } else {
            throw new IllegalArgumentException("Email already in use");
        }
    }

    public userEntity accountExist(loginRequest request) {
        // firs check if email exists
        Optional<userEntity> optionalUser = userRepo.findByEmail(request.getEmail());
        // if user doesnt exist
        if (optionalUser.isEmpty()) {
            throw new IllegalArgumentException("User is not found. Try again");
        }
        userEntity user = optionalUser.get(); // creates a user entity in which you can get/set values

        if (!user.getPassword().equals(request.getPassword())) {
            throw new IllegalArgumentException("Passwords do not match");
        }
        return user;
    }

}
