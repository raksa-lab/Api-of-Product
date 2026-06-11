package com.example.restful_api_product_spring_boot.repository;

import com.example.restful_api_product_spring_boot.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class ProductRepositoryOld {
    private final List<Product> productList = new ArrayList<>(){{
        add(new Product(1001 , "Cocacola" , "Nice When Cool" , 23.2f , 2));
        add(new Product(1002 , "Idol" , "The Best For GenZ" , 21.3f , 4));
        add( new Product(1003,"Sting","Unlimited Sweetness ",0.65f,4));
    }};

    public List<Product> getAllProduct(){
        return productList;
    }
    public Product createProduct(Product product){
        productList.add(product);
        return product;
    }
    public Product findProductById(Integer id){
        return productList.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Product with id " + id + " not found")
                );
    }

    public boolean deleteProductById(Integer id){
        return productList
                .removeIf(product -> product.getId() == id);
    }
    public Product updateProductById(Product updateProduct){
        for(int i =0 ; i<productList.size() ; i++){
            var product = productList.get(i);
            if (product.getId() == updateProduct.getId() ){
                productList.set(i , updateProduct);
                return updateProduct;
            }
        }
        return null;
    }

}
