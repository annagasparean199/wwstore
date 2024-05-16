package com.example.wwstore.service;

import com.example.wwstore.model.UserEntity;
import com.example.wwstore.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity saveUser(@Valid UserEntity user) {
        // You can add any additional logic here before saving the user.
        return userRepository.save(user);
    }

    public Optional<UserEntity> getUserByEmailAndPassword(String email, String password) {
        return Optional.ofNullable(userRepository.findByEmailAndPassword(email, password));
    }
}
