package com.product.improv.com.product.improv.service;

import com.product.improv.com.product.improv.entity.Product;
import com.product.improv.com.product.improv.entity.User;
import com.product.improv.com.product.improv.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductByName(String name) {
        return productRepository.findByName(name);
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }
}
