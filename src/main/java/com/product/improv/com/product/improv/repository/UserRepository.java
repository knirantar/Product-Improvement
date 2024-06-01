package com.product.improv.com.product.improv.repository;

import com.product.improv.com.product.improv.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, ObjectId> {

    User findByUsername(String username);
}
