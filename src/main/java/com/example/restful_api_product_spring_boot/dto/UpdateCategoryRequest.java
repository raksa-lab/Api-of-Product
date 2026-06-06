package com.example.restful_api_product_spring_boot.dto;

public record UpdateCategoryRequest(
        String name,
        String description,
        String expireDate
) {
}
