package com.example.restful_api_product_spring_boot.service;

import com.example.restful_api_product_spring_boot.dto.ProductRequest;
import com.example.restful_api_product_spring_boot.dto.ProductResponse;
import com.example.restful_api_product_spring_boot.dto.UpdateProductRequest;

import java.util.List;

public interface ProductService {
    ProductResponse createProduct(ProductRequest productRequest);
    List<ProductResponse> findAllProducts();

    ProductResponse findProductById(Integer id);

    ProductResponse updateProduct(Integer id , UpdateProductRequest request);
    boolean deleteProduct(Long id);
}
