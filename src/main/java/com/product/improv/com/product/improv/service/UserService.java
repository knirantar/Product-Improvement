package com.product.improv.com.product.improv.service;

import com.product.improv.com.product.improv.dto.LoginForm;
import com.product.improv.com.product.improv.entity.User;
import com.product.improv.com.product.improv.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;


    @Autowired
    UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void saveUser(User user) {
        try {
            user.setPassword(this.passwordEncoder.encode(user.getPassword()));
            user.setActive(true);
            userRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save user", e);
        }
    }

    public void login(LoginForm loginForm) {
        User user = userRepository.findByUsername(loginForm.getUsername());
        System.out.println(user.toString());
    }
}
