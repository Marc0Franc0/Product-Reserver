package com.ProductMicroservice.controller;

import com.ProductMicroservice.model.Product;
import com.ProductMicroservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping("")
    public ResponseEntity getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAll());
    }
    @PostMapping("")
    public ResponseEntity create(@RequestBody Product product){
        return ResponseEntity.status(HttpStatus.OK).body(productService.create(product));
    }
}
