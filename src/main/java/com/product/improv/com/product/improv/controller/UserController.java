package com.product.improv.com.product.improv.controller;

import com.product.improv.com.product.improv.dto.LoginForm;
import com.product.improv.com.product.improv.dto.ApiMessage;
import com.product.improv.com.product.improv.entity.User;
import com.product.improv.com.product.improv.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        try {
            userService.saveUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body("User details saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save user: " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginForm loginForm) {
        try {
            ApiMessage apiMessage = userService.login(loginForm);
            return ResponseEntity.status(HttpStatus.CREATED).body(apiMessage.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to login user: " + e.getMessage());
        }
    }

    @PutMapping("/update/{username}")
    public ResponseEntity<String> updateUser(@PathVariable("username") String username, @RequestBody User user) {
        try {
            userService.update(user);
            return ResponseEntity.status(HttpStatus.CREATED).body("User details updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to login user: " + e.getMessage());
        }
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> getUserDetails(@PathVariable("username") String username) {

        User user = userService.getUserDetails(username);
        if (user != null) {
            // Return user details if found
            return ResponseEntity.ok().body(user);
        } else {
            // Return not found error response
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

    //TODO - API to fetch all users data
    @GetMapping("/all")
    public ResponseEntity<?> getUserList() {

        List<User> users = userService.getAllUserDetails();
        if (users != null) {
            // Return user details if found
            return ResponseEntity.ok().body(users);
        } else {
            // Return not found error response
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Users not found");
        }
    }

}
