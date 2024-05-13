package com.product.improv.com.product.improv.service;

import com.product.improv.com.product.improv.dto.LoginForm;
import com.product.improv.com.product.improv.dto.ApiMessage;
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

    public ApiMessage login(LoginForm loginForm) {
        User user = userRepository.findByUsername(loginForm.getUsername());
        ApiMessage apiMessage = new ApiMessage();
        if (user != null) {
            String encodedPassword = user.getPassword();
            boolean isPasswordRight = passwordEncoder.matches(loginForm.getPassword(), encodedPassword);
            if (isPasswordRight) {
                apiMessage.setMessage("User is logged in successfully");
                apiMessage.setSuccess(true);
            }
            else {
                apiMessage.setMessage("Password is incorrect");
                apiMessage.setSuccess(false);
            }
        } else {
            apiMessage.setMessage("User does not exist");
            apiMessage.setSuccess(false);
        }
        return apiMessage;
    }

    public ApiMessage update(User user) {
        User savedUser = userRepository.findByUsername(user.getUsername());
        ApiMessage apiMessage = new ApiMessage();
        if(savedUser != null) {
            if (user.getUsername() != null) {
                savedUser.setUsername(user.getUsername());
            }
            if (user.getEmail() != null) {
                savedUser.setEmail(user.getEmail());
            }
        } else {
            apiMessage.setMessage("User you are updating does not exist");
            apiMessage.setSuccess(false);
        }
        return apiMessage;
    }

    public User getUserDetails(String username) {
        User savedUser = userRepository.findByUsername(username);
        return savedUser;
    }
}
