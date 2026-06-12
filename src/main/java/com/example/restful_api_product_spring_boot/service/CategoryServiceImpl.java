package com.example.restful_api_product_spring_boot.service;

import com.example.restful_api_product_spring_boot.advisor.ResourceAlreadyExistException;
import com.example.restful_api_product_spring_boot.dto.CategoryRequest;
import com.example.restful_api_product_spring_boot.dto.CategoryResponse;
import com.example.restful_api_product_spring_boot.dto.UpdateCategoryRequest;
import com.example.restful_api_product_spring_boot.entity.Category;
import com.example.restful_api_product_spring_boot.mapper.CategoryMapper;
import com.example.restful_api_product_spring_boot.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;


    @Override
    public CategoryResponse createCategory(CategoryRequest categoryRequest) {
        Category category = categoryMapper.toEntity(categoryRequest);
        if(categoryRepository.existsByName(categoryRequest.name())){
            throw new ResourceAlreadyExistException("Category with name = "+category.getName()+" already exists");
        }
        var newCategory = categoryRepository.save(category);
        return categoryMapper.toResponse(newCategory);
    }

//    @Override
//    public List<CategoryResponse> findAllCategories() {
//       return categoryRepository.findAll()
//               .stream()
//               .map(categoryMapper::toResponse)
//               .toList();
//    }

    @Override
    public CategoryResponse findCategoryById(Integer id) {
        return null;
    }

    @Override
    public boolean deleteCategory(Integer id) {
        if(categoryRepository.existsById(id)){
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public CategoryResponse updateCategory(Integer id, UpdateCategoryRequest request) {
       return null;
    }

    @Override
    public Page<CategoryResponse> findAllCategories(int page, int size, String sortBy, String keyword) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        if (keyword == null || keyword.trim().isEmpty()) {
            return categoryRepository.findAll(pageable)
                    .map(categoryMapper::toResponse);
        }
        return categoryRepository.findByNameContainingIgnoreCase(keyword, pageable)
                .map(categoryMapper::toResponse);
    }
}
