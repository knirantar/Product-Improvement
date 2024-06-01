package com.product.improv.com.product.improv.service;

import com.product.improv.com.product.improv.entity.Product;
import com.product.improv.com.product.improv.entity.Review;
import com.product.improv.com.product.improv.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewsService {
    @Autowired
    ReviewRepository reviewRepository;

    public void saveReview(Review review) {
        reviewRepository.save(review);
    }
}
