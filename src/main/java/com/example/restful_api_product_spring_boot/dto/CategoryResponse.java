package com.example.restful_api_product_spring_boot.dto;

import java.time.LocalDateTime;

public record CategoryResponse(
        Integer id,
        String name ,
        String description,
        LocalDateTime expireDate
) {
}
