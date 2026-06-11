package com.example.restful_api_product_spring_boot.dto;

import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record CategoryRequest(
        @Size(min = 1, max = 100)
        String name,
        @Size(min = 1, max = 255)
        String description,
        LocalDateTime expireDate
) {
}
