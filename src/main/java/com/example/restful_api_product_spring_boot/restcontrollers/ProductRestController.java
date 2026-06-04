package com.example.restful_api_product_spring_boot.restcontrollers;

import com.example.restful_api_product_spring_boot.dto.ProductRequest;
import com.example.restful_api_product_spring_boot.dto.ProductResponse;
import com.example.restful_api_product_spring_boot.dto.UpdateProductRequest;
import com.example.restful_api_product_spring_boot.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductRestController {
    private final ProductService productService;

    @GetMapping
    public List<ProductResponse> getProducts(){
        return productService.findAllProducts();
    }

    @GetMapping("/{id}")
    public ProductResponse getProductById(@PathVariable Integer id){
        return productService.findProductById(id);
    }

    @PostMapping
    public ProductResponse createProduct(@RequestBody ProductRequest request){
        return productService.createProduct(request);
    }

    @PatchMapping("/{id}")
    public ProductResponse updateProduct(@PathVariable Integer id, @RequestBody UpdateProductRequest request){
        return productService.updateProduct(id, request);
    }
}
