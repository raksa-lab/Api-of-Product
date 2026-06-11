package com.example.restful_api_product_spring_boot.repository;

import com.example.restful_api_product_spring_boot.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category , Integer> {
}
