package com.product.improv.com.product.improv.controller;

import com.product.improv.com.product.improv.entity.Product;
import com.product.improv.com.product.improv.entity.Review;
import com.product.improv.com.product.improv.service.ProductService;
import com.product.improv.com.product.improv.service.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ReviewsController {
    @Autowired
    ReviewsService reviewsService;

    @PostMapping("/add")
    public ResponseEntity<String> addReview(@RequestBody Review review) {
        try {
            reviewsService.saveReview(review);
            return ResponseEntity.status(HttpStatus.CREATED).body("Review details saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save review details: " + e.getMessage());
        }
    }
}
