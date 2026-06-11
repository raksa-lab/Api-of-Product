package com.example.restful_api_product_spring_boot.restcontrollers;

import com.example.restful_api_product_spring_boot.dto.CategoryRequest;
import com.example.restful_api_product_spring_boot.dto.CategoryResponse;
import com.example.restful_api_product_spring_boot.dto.UpdateCategoryRequest;
import com.example.restful_api_product_spring_boot.dto.UpdateProductRequest;
import com.example.restful_api_product_spring_boot.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryRestController {
    private final CategoryService categoryService;
//    @GetMapping
//    public List<CategoryResponse> getCategory(){
//        return categoryService.findAllCategories();
//    }
//
//    @GetMapping("/{id}")
//    public CategoryResponse getCategoryById(@PathVariable Integer id){
//        return categoryService.findCategoryById(id);
//    }
//
//    @PostMapping
//    public CategoryResponse createCategory(@RequestBody CategoryRequest request){
//        return categoryService.createCategory(request);
//    }
//
//    @PatchMapping("/{id}")
//    public CategoryResponse updateCategory(@PathVariable Integer id , @RequestBody UpdateCategoryRequest updateCategoryRequest){
//        return categoryService.updateCategory(id , updateCategoryRequest);
//    }

    @GetMapping
    List<CategoryResponse> getAllCategory(){
        return categoryService.findAllCategories();
    }

    @PostMapping
    public CategoryResponse createCategory(@RequestBody CategoryRequest categoryRequest){
        return categoryService.createCategory(categoryRequest);
    }
}
