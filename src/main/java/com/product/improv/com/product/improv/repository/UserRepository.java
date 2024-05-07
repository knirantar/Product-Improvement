package com.product.improv.com.product.improv.repository;

import com.product.improv.com.product.improv.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

}
