package com.example.davideshop.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.davideshop.dto.loginRequest;
import com.example.davideshop.dto.signUpRequest;
import com.example.davideshop.dto.userUpdateRequest;
import com.example.davideshop.model.userEntity;
import com.example.davideshop.repository.userRepo;

@Service
public class userService {
    private final userRepo userRepo;

    public userService(userRepo userRepo) {
        this.userRepo = userRepo;
    }

    public userEntity updateUserAdress(@RequestBody userUpdateRequest request){
        Optional<userEntity> optionalUser = userRepo.findById(request.getId());
        if(optionalUser.isEmpty()){
            throw new IllegalArgumentException("User not found by ID");
        }

        userEntity user = optionalUser.get();
        user.setAddress(request.getAddress());
        user.setZipcode(request.getZipcode());
        user.setCountry(request.getCountry());
        user.setCity(request.getCity());
        return userRepo.save(user);
    }

    public userEntity updateUser(@RequestBody userUpdateRequest request) {
        System.out.println("updateUser email = " + request.getEmail());
        System.out.println("updateUser fullName = " + request.getFullName());

        Optional<userEntity> optionalUser = userRepo.findById(request.getId());

        if (optionalUser.isEmpty()) {
            throw new IllegalArgumentException("User not found");
        }

        userEntity user = optionalUser.get();

        
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        
        if(StringUtils.hasText(request.getPassword())){ // basically saying that if request.getPassword from dto has a 
            //password field, then update database, else ignore this and just save the name and email
            user.setPassword(request.getPassword());
        }

        return userRepo.save(user);
    }


    public userEntity register(signUpRequest request) {
        if (!userRepo.findByEmail(request.getEmail()).isPresent()) {
            userEntity user = new userEntity();
            user.setEmail(request.getEmail());
            user.setFullName(request.getFullName());
            user.setPassword(request.getPassword());
            user.setAddress(request.getAddress());
            user.setCity(request.getCity());
            user.setCountry(request.getCountry());
            user.setZipcode(request.getZipcode());
            return userRepo.save(user);
        } else {
            throw new IllegalArgumentException("Email already in use");
        }
    }

    public boolean emailExists(String email) {
    return userRepo.existsByEmail(email);
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
