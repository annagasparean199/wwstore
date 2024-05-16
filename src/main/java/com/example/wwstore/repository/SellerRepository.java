package com.example.wwstore.repository;


import com.example.wwstore.model.SellerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<SellerEntity, Long> {
    SellerEntity findByEmailAndPassword(String email, String password);
}