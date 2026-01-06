package com.example.davideshop.repository;
import com.example.davideshop.model.productEntity;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
public interface productRepo extends JpaRepository<productEntity,Long> {
    //optional returns a singluar entity, while List returns multiple
    Optional<productEntity> findById(Long id);

    List<productEntity> findByCreatedBy(String email);
}
