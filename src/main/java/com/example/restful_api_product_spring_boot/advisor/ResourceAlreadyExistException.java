package com.example.restful_api_product_spring_boot.advisor;

public class ResourceAlreadyExistException extends RuntimeException {
    public ResourceAlreadyExistException(String message) {

        super(message);
    }
}
