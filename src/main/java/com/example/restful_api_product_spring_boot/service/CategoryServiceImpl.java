package com.example.restful_api_product_spring_boot.service;

import com.example.restful_api_product_spring_boot.dto.CategoryRequest;
import com.example.restful_api_product_spring_boot.dto.CategoryResponse;
import com.example.restful_api_product_spring_boot.dto.UpdateCategoryRequest;
import com.example.restful_api_product_spring_boot.entity.Category;
import com.example.restful_api_product_spring_boot.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private static final Logger log = LoggerFactory.getLogger(CategoryServiceImpl.class);
    private final CategoryRepository categoryRepository;
    private Integer nextId = 1;

    private Category mapToEntity (CategoryRequest categoryRequest){
        Category category = new Category();
        category.setName(categoryRequest.name());
        category.setDescription(categoryRequest.description());
        category.setExpireDate(categoryRequest.expireDate());

        return category;
    }
    private CategoryResponse mapToResponse (Category category){
        return new CategoryResponse(
                category.getId(),
                category.getName(),
                category.getDescription(),
                category.getExpireDate()
        );
    }

    @Override
    public CategoryResponse createCategory(CategoryRequest categoryRequest) {
        var category = mapToEntity(categoryRequest);
        category.setId(nextId++);
        return mapToResponse(categoryRepository.createCategory(category));
    }

    @Override
    public List<CategoryResponse> findAllCategories() {
        return categoryRepository.getAllCategory()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public CategoryResponse findCategoryById(Integer id) {
        var category = categoryRepository.findCategoryById(id);
        if (category == null){
            log.info("Category with id {} not found" , id);
            return null;
        }
        return mapToResponse(category);
    }

    @Override
    public boolean deleteCategory(Integer id) {
            if (categoryRepository.deleteCategoryById(id)){
                log.info("Category with id {} deleted successfully" , id);
                return true;
            }
            log.info("Failed to delete category with id {}" , id);
        return false;
    }

    @Override
    public CategoryResponse updateCategory(Integer id, UpdateCategoryRequest request) {
        var categoryExiting = categoryRepository.findCategoryById(id);

        if (categoryExiting == null){
            log.info("Category with id {} not found" , id);
            return null;
        }
        if(request.name() != null)
            categoryExiting.setName(request.name());
        if(request.description() != null)
            categoryExiting.setDescription(request.description());
        if(request.expireDate() != null)
            categoryExiting.setExpireDate(LocalDateTime.parse(request.expireDate()));
        categoryRepository.updateCategoryById(categoryExiting);
        return mapToResponse(categoryExiting);
    }
}
