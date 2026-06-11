package com.example.restful_api_product_spring_boot.service;

import com.example.restful_api_product_spring_boot.dto.ProductRequest;
import com.example.restful_api_product_spring_boot.dto.ProductResponse;
import com.example.restful_api_product_spring_boot.dto.UpdateProductRequest;
import com.example.restful_api_product_spring_boot.entity.Product;
import com.example.restful_api_product_spring_boot.repository.ProductRepository;
import com.example.restful_api_product_spring_boot.repository.ProductRepositoryOld;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;
//    private Integer nextId = 1004;

    private Product mapToEntity(ProductRequest request){
        Product product = new Product();
        product.setName(request.name());
        product.setDescription(request.description());
        product.setPrice(request.price());

        return product;
    }
    private ProductResponse mapToResponse(Product product){
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice()
        );
    }
    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
        var product = mapToEntity(productRequest);
        product.setUserId(1);
//        product.setId(nextId++);
        return mapToResponse(productRepository.save(product));
    }

    @Override
    public List<ProductResponse> findAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }
    @Override
    public ProductResponse findProductById(Integer id){
        var product = productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Product with id" + id + "not found"));
        return mapToResponse(product);
    }
    @Override
    public ProductResponse updateProduct(Integer id , UpdateProductRequest request) {
        var productExiting = productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Product with id" + id + "not found"));

//        if (productExiting == null){
//            log.info("Product with id {} not found" , id);
//            return null;
//        }
        if(request.name() != null)
            productExiting.setName(request.name());
        if(request.description() != null)
            productExiting.setDescription(request.description());
        if(request.price() != null)
            productExiting.setPrice(request.price());
        productRepository.save(productExiting);
        return mapToResponse(productExiting);

    }

    @Override
    public boolean deleteProduct(Integer id) {

//        return false;
        if(productRepository.existsById(id)){
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
