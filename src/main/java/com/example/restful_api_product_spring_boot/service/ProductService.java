package com.example.restful_api_product_spring_boot.service;

import com.example.restful_api_product_spring_boot.dto.ProductRequest;
import com.example.restful_api_product_spring_boot.dto.ProductResponse;
import com.example.restful_api_product_spring_boot.dto.UpdateProductRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    ProductResponse createProduct(ProductRequest productRequest);
//    List<ProductResponse> findAllProducts();

    //get all product with pagination and keyword
    Page<ProductResponse> findAllProducts(String keyword , int page , int size , String sortBy);
    ProductResponse findProductById(Integer id);

    ProductResponse updateProduct(Integer id , UpdateProductRequest request);
    boolean deleteProduct(Integer id);

    //get all product with pagination and keyword
//    Page<ProductResponse> findAllProducts(int page, int size, String sortBy, String keyword);
}
