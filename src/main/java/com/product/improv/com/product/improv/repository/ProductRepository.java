package com.product.improv.com.product.improv.repository;

import com.product.improv.com.product.improv.entity.Product;
import com.product.improv.com.product.improv.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    Product findByName(String name);

}
