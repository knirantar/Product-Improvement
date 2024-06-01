package com.product.improv.com.product.improv.repository;

import com.product.improv.com.product.improv.entity.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepository extends MongoRepository<Review, String> {
}
