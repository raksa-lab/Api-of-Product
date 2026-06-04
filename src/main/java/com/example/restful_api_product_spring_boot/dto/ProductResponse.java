package com.example.restful_api_product_spring_boot.dto;

public record ProductResponse(
        Integer id,
        String name,
        String description,
        float price
) {
}
