package com.example.restful_api_product_spring_boot.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ErrorResponse<T>(
        LocalDateTime timestamp,
        String message,
        T errors ,
        Integer status
) {
}
