package com.example.restful_api_product_spring_boot.service;

import com.example.restful_api_product_spring_boot.dto.CategoryRequest;
import com.example.restful_api_product_spring_boot.dto.CategoryResponse;
import com.example.restful_api_product_spring_boot.dto.UpdateCategoryRequest;

import java.util.List;

public interface CategoryService {
    CategoryResponse createCategory(CategoryRequest categoryRequest);
    List<CategoryResponse> findAllCategories();
    CategoryResponse findCategoryById(Integer id);
    boolean deleteCategory(Integer id);
    CategoryResponse updateCategory(Integer id , UpdateCategoryRequest request);
}
