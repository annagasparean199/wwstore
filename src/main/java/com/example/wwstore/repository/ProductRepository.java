package com.example.wwstore.repository;

import com.example.wwstore.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

   // ProductEntity findByID(Long id);
}
