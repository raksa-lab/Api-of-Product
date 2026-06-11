package com.example.restful_api_product_spring_boot.repository;


import com.example.restful_api_product_spring_boot.entity.Category;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepositoryOld {

    private final List<Category> categoryList = new ArrayList<>(){{
//        add(new Category(1,"Electronics","Electronic devices and gadgets", LocalDateTime.now().plusDays(10)));
//        add(new Category(2,"Clothing","Apparel and fashion items",LocalDateTime.now().plusDays(20)));
//        add(new Category(3,"Books","Printed and digital books",LocalDateTime.now().plusDays(1)));
    }};


    public List<Category> getAllCategory() {
        return categoryList;
    }
    public Category createCategory(Category category){
        categoryList.add(category);
        return category;
    }

    public Category findCategoryById(Integer id){
        return categoryList.stream()
                .filter(category -> category.getId() == id)
                .findFirst()
                .orElse(null);
    }
    public boolean deleteCategoryById(Integer id){
        return categoryList
                .removeIf(category -> category.getId() == id);
    }
    public Category updateCategoryById(Category updateCategory){
        for(int i = 0 ; i<categoryList.size() ;i++){
            var product = categoryList.get(i);
            if (product.getId() == updateCategory.getId()){
                categoryList.set(i , updateCategory);
                return updateCategory;
            }
        }
        return null;
    }
}
