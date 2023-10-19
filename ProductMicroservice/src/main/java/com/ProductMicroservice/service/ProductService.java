package com.ProductMicroservice.service;

import com.ProductMicroservice.dto.ProductDTO;
import com.ProductMicroservice.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {
     Optional<List<Product>> getAll();

     Optional<Product> getById(String id);

     Product create(ProductDTO productDTO);

     boolean getExistence(String code);

     Product update(String id, ProductDTO productDTO);

     Optional<Product> deleteById(String id);

}
