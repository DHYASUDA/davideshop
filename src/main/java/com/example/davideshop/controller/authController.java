package com.example.davideshop.controller;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.davideshop.dto.loginRequest;
import com.example.davideshop.dto.signUpRequest;
import com.example.davideshop.model.userEntity;
import com.example.davideshop.service.userService;
@RestController //tells java that this class is a restcontroller and to look for http requests
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173") //connects a bridge between react and spring
public class authController {
    private final userService userService;

    public authController(userService userService){
        this.userService  = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<userEntity> signUp(@RequestBody signUpRequest request){
        userEntity user = userService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
    @PostMapping("/login")
    public ResponseEntity<userEntity> login(@RequestBody loginRequest request){
        userEntity user = userService.accountExist(request);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/email-exists")
    public ResponseEntity<Map<String, Boolean>> emailExists(@RequestParam("email") String email) {
    boolean exists = userService.emailExists(email);
    return ResponseEntity.ok(Map.of("exists", exists));
}

    //if email already exist case
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleIllegalArgument(IllegalArgumentException ex){
        return ex.getMessage();
    }
}
