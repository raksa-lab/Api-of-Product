package com.example.restful_api_product_spring_boot.repository;

import com.example.restful_api_product_spring_boot.entity.Category;
import com.example.restful_api_product_spring_boot.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category , Integer> {
    boolean existsByName(String name);
    Page<Category> findByNameContainingIgnoreCase(String keyword, Pageable pageable);
}
