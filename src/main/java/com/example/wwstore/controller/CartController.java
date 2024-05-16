package com.example.wwstore.controller;


import com.example.wwstore.model.CartEntity;
import com.example.wwstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "http://localhost:4200")
public class CartController {

    @Autowired
    private CartService cartService;
    @GetMapping
    public List<CartEntity> getAllCarts() {
        return cartService.getAllCarts();
    }

    @GetMapping("/{id}")
    public CartEntity getCartById(@PathVariable Long id) {
        return cartService.getCartById(id).orElse(null);
    }

    @PostMapping()
    public ResponseEntity<Object> addToCart(@RequestBody CartEntity cart) {
        try {
            System.out.println("Received request to add to cart");
            CartEntity addedCart = cartService.addToCart(cart);
            System.out.println("Successfully added to cart");
            return ResponseEntity.ok(addedCart);
        } catch (Exception e) {
            System.out.println("Error adding to cart");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding to cart");
        }
    }

    @DeleteMapping("/{id}")
    public void removeFromCart(@PathVariable Long id) {
        cartService.removeFromCart(id);
    }

}
