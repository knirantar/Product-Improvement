package com.product.improv.com.product.improv.controller;

import com.product.improv.com.product.improv.entity.Product;
import com.product.improv.com.product.improv.entity.User;
import com.product.improv.com.product.improv.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
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

}
