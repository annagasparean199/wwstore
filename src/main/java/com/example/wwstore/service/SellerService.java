package com.example.wwstore.service;

import com.example.wwstore.model.SellerEntity;
import com.example.wwstore.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerService {
    @Autowired
    private SellerRepository sellerRepository;

    public SellerEntity signUp(SellerEntity seller) {
        return sellerRepository.save(seller);
    }

    public SellerEntity login(String email, String password) {
        return sellerRepository.findByEmailAndPassword(email, password);
    }

        public List<SellerEntity> getAllSellers() {
            return sellerRepository.findAll();
        }

        public SellerEntity getSellerById(Long id) {
            return sellerRepository.findById(id).orElse(null);
        }

        public SellerEntity createSeller(SellerEntity seller) {
            return sellerRepository.save(seller);
        }

        public SellerEntity updateSeller(Long id, SellerEntity seller) {
            SellerEntity existingSeller = sellerRepository.findById(id).orElse(null);

            if (existingSeller != null) {
                existingSeller.setName(seller.getName());
                existingSeller.setEmail(seller.getEmail());
                return sellerRepository.save(existingSeller);
            } else {
                return null;
            }
        }

        public void deleteSeller(Long id) {
            sellerRepository.deleteById(id);
        }
}