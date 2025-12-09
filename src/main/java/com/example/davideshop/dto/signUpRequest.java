package com.example.davideshop.dto;

public class signUpRequest {
    private String email;
    private String fullName;
    private String password;

    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public String getfullName(){
        return this.fullName;
    }
    public void setfullName(String fullName){
        this.fullName = fullName;
    }
}
