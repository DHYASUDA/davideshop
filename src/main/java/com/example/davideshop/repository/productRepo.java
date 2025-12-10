package com.example.davideshop.repository;
import com.example.davideshop.model.productEntity;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
public interface productRepo extends JpaRepository<productEntity,Long> {
    Optional<productEntity> findById(Long id);
}
