package com.example.restful_api_product_spring_boot.service;

import com.example.restful_api_product_spring_boot.dto.ProductRequest;
import com.example.restful_api_product_spring_boot.dto.ProductResponse;
import com.example.restful_api_product_spring_boot.dto.UpdateProductRequest;
import com.example.restful_api_product_spring_boot.entity.Product;
import com.example.restful_api_product_spring_boot.mapper.ProductMapper;
import com.example.restful_api_product_spring_boot.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = productMapper.mapToProduct(productRequest);
        product.setUserId(1);
//        product.setId(nextId++);

        var newProduct = productRepository.save(product);
        return productMapper.mapToResponse(newProduct);
    }

//    @Override
//    public List<ProductResponse> findAllProducts() {
//        return productRepository.findAll()
//                .stream()
//                .map(productMapper::mapToResponse)
//                .toList();
//    }


//
//    @Override
//    public Page<ProductResponse> findAllProducts(Pageable pageable) {
//        return productRepository.findAll(pageable)
//                .map(productMapper::mapToResponse);
//    }

    @Override
    public ProductResponse findProductById(Integer id){
        var product = productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Product with id" + id + "not found"));
        return productMapper.mapToResponse(product);
    }
    @Override
    public ProductResponse updateProduct(Integer id , UpdateProductRequest request) {
        var productExiting = productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Product with id" + id + "not found"));
        if(request.name() != null)
            productExiting.setName(request.name());
        if(request.description() != null)
            productExiting.setDescription(request.description());
        if(request.price() != null)
            productExiting.setPrice(request.price());
        productRepository.save(productExiting);
        return productMapper.mapToResponse(productExiting);

    }

    @Override
    public boolean deleteProduct(Integer id) {
        if(productRepository.existsById(id)){
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Page<ProductResponse> findAllProducts(String keyword , int page , int size , String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        if(keyword == null || keyword.trim().isEmpty()){
            return productRepository.findAll(pageable)
                    .map(productMapper::mapToResponse);
        }
        return productRepository.findByNameContainingIgnoreCase(keyword, pageable)
                .map(productMapper::mapToResponse);
    }

}
