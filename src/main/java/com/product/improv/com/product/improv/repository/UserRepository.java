package com.product.improv.com.product.improv.repository;

import com.product.improv.com.product.improv.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    User findByUsername(String username);
}
