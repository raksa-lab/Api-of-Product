package com.example.restful_api_product_spring_boot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Category {
    private int id;
    private String name;
    private String description;
    private LocalDateTime expireDate;

    public boolean isExpired() {
        return expireDate != null && LocalDateTime.now().isAfter(expireDate);
    }
}
