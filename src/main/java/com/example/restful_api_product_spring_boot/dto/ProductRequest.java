package com.example.restful_api_product_spring_boot.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductRequest(
        @NotBlank(message = "Name is required")
        String name,
        @NotBlank(message = "Description is required")
        String description,
        @NotNull(message = "Price is required")
        @Positive(message = "Price must be a positive number")
        float price
) {

}
