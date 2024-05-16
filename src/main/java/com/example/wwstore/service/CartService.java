package com.example.wwstore.service;


import com.example.wwstore.model.CartEntity;
import com.example.wwstore.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public List<CartEntity> getAllCarts() {
        return cartRepository.findAll();
    }

    public Optional<CartEntity> getCartById(Long id) {
        return cartRepository.findById(id);
    }

    public CartEntity addToCart(CartEntity cart) {
        return cartRepository.save(cart);
    }

    public void removeFromCart(Long id) {
        cartRepository.deleteById(id);
    }
}
