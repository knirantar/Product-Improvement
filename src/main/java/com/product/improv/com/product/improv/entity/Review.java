package com.product.improv.com.product.improv.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("reviews")
public class Review {

    private String userId;
    private String comment;
    private LocalDateTime timestamp;

    public Review(String userId, String comment, LocalDateTime timestamp) {
        this.userId = userId;
        this.comment = comment;
        this.timestamp = timestamp;
    }

    public Review() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
