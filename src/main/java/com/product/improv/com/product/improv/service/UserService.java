package com.product.improv.com.product.improv.service;

import com.product.improv.com.product.improv.dto.LoginForm;
import com.product.improv.com.product.improv.dto.LoginMessage;
import com.product.improv.com.product.improv.entity.User;
import com.product.improv.com.product.improv.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public LoginMessage login(LoginForm loginForm) {
        User user = userRepository.findByUsername(loginForm.getUsername());
        LoginMessage loginMessage = new LoginMessage();
        if (user != null) {
            String encodedPassword = user.getPassword();
            boolean isPasswordRight = passwordEncoder.matches(loginForm.getPassword(), encodedPassword);
            if (isPasswordRight) {
                loginMessage.setMessage("User is logged in successfully");
                loginMessage.setSuccess(true);
            }
            else {
                loginMessage.setMessage("Password is incorrect");
                loginMessage.setSuccess(false);
            }
        } else {
            loginMessage.setMessage("User does not exist");
            loginMessage.setSuccess(false);
        }
        return loginMessage;
    }
}
