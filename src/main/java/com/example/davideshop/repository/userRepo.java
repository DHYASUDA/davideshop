package com.example.davideshop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.davideshop.model.userEntity;
public interface userRepo extends JpaRepository<userEntity, Long>{
    Optional<userEntity> findByEmail(String email);
    Optional<userEntity> findByPassword(String password);
    Optional<userEntity> findById(String ID);
    boolean existsByEmail(String email);


    
}
