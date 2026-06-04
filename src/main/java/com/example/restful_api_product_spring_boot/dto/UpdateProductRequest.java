package com.example.restful_api_product_spring_boot.dto;

public record UpdateProductRequest(
        String name,
        String description ,
        Float price
) {
}
