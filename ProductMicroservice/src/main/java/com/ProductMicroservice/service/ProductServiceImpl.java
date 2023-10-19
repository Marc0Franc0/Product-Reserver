package com.ProductMicroservice.service;

import com.ProductMicroservice.dto.ProductDTO;
import com.ProductMicroservice.model.Product;
import com.ProductMicroservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    public Optional<List<Product>> getAll(){
        return Optional.of(productRepository.findAll());
    }
    public Optional<Product> getById(String id){
        return productRepository.findById(id);
    }

    public Product create(ProductDTO productDTO) {
        return productRepository.save(
                new Product(
                        productDTO.getName(),
                        productDTO.getDescription(),
                        productDTO.getUnitPrice()
                )
        );
    }

    public boolean getExistence(String code) {
        boolean exists = false;
        boolean product= productRepository.existsById(code);
        if(product){
            exists = true;
        }
        return exists;
    }

    public Product update(String id, ProductDTO productDTO) {
        Product product = new Product(
                id,
                productDTO.getName(),
                productDTO.getDescription(),
                productDTO.getUnitPrice());
            if(getExistence(product.getId())){
               return productRepository.save(product);
            }
            return null;
    }

    @Override
    public Optional<Product> deleteById(String id) {
        if(getExistence(id)){
             productRepository.deleteById(id);
             return getById(id);
        }
        return null;
    }
}
