package com.example.restful_api_product_spring_boot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "categories_tbl")
public class Category {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private LocalDateTime expireDate;

    @OneToMany(mappedBy = "category")
    private java.util.List<Product> products;
    
    public boolean isExpired() {
        return expireDate != null && LocalDateTime.now().isAfter(expireDate);
    }
}
