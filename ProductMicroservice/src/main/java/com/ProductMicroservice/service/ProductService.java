package com.ProductMicroservice.service;

import com.ProductMicroservice.model.Product;
import com.ProductMicroservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public Product create(Product product) {
        return productRepository.save(
                new Product(
                        product.getName(),
                        product.getDescription(),
                        product.getUnitPrice()
                )
        );
    }
}
