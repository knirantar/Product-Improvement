package com.product.improv.com.product.improv.controller;

import com.product.improv.com.product.improv.entity.Product;
import com.product.improv.com.product.improv.entity.User;
import com.product.improv.com.product.improv.service.ProductService;
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
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllProdoucts() {
        List<Product> products = productService.getAllProducts();
        if (products != null) {
            // Return product details if found
            return ResponseEntity.ok().body(products);
        } else {
            // Return not found error response
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Products not found");
        }
    }

    @PostMapping("/add")
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        try {
            productService.saveProduct(product);
            return ResponseEntity.status(HttpStatus.CREATED).body("Product details saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save product details: " + e.getMessage());
        }
    }



}
