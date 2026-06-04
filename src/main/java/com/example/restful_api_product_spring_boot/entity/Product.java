package com.example.restful_api_product_spring_boot.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Product {
    private int id;
    private String name;
    private String description;
    private float price;
    private int userId;
}
