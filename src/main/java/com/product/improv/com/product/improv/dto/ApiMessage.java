package com.product.improv.com.product.improv.dto;

public class ApiMessage {
    private String message;
    private boolean success;

    // Constructors
    public ApiMessage() {
    }

    public ApiMessage(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    // Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
