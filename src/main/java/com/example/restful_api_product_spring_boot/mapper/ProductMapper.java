package com.example.restful_api_product_spring_boot.mapper;


import com.example.restful_api_product_spring_boot.dto.ProductRequest;
import com.example.restful_api_product_spring_boot.dto.ProductResponse;
import com.example.restful_api_product_spring_boot.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper{
    ProductResponse mapToResponse(Product product);
    Product mapToProduct(ProductRequest productRequest);
}
