package com.example.wwstore.controller;

import com.example.wwstore.model.SellerEntity;
import com.example.wwstore.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seller")
@CrossOrigin(origins = "http://localhost:4200")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @GetMapping
    public List<SellerEntity> getAllSellers() {
        return sellerService.getAllSellers();
    }

    @GetMapping("/{id}")
    public SellerEntity getSellerById(@PathVariable Long id) {
        return sellerService.getSellerById(id);
    }

    @PostMapping
    public SellerEntity createSeller(@RequestBody SellerEntity seller) {
        return sellerService.createSeller(seller);
    }

    @PutMapping("/{id}")
    public SellerEntity updateSeller(@PathVariable Long id, @RequestBody SellerEntity seller) {
        return sellerService.updateSeller(id, seller);
    }

    @DeleteMapping("/{id}")
    public void deleteSeller(@PathVariable Long id) {
        sellerService.deleteSeller(id);
    }
}

