package com.example.wwstore.repository;


import com.example.wwstore.model.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CartRepository extends JpaRepository<CartEntity, Long> {
}