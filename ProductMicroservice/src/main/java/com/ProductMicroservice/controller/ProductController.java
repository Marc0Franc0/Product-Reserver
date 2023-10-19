package com.ProductMicroservice.controller;

import com.ProductMicroservice.dto.ProductDTO;
import com.ProductMicroservice.model.Product;
import com.ProductMicroservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    ProductService productService;
    ResponseEntity<?> methodResponse;
    @GetMapping("")
    public ResponseEntity getAll(){
        Optional<List<Product>> list = productService.getAll();
        if(list.isPresent()){
            ResponseEntity.status(HttpStatus.OK).body(list);
        }
        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Nothing was found");
    }
    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable String id){
        Optional<Product> prod = productService.getById(id);
        if(prod.isPresent()){
            ResponseEntity.status(HttpStatus.OK).body(prod);
        }
        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Product not found");
    }
    @GetMapping("/{code}")
    public ResponseEntity<Boolean> getExistence(@PathVariable String code){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getExistence(code));
    }
    @PostMapping("")
    public ResponseEntity create(@RequestBody ProductDTO productDTO){
        return ResponseEntity.status(HttpStatus.OK).body(productService.create(productDTO));
    }
    @PutMapping("/{id}")
    public ResponseEntity updateById(@PathVariable String id,@RequestBody ProductDTO productDTO) {
       Product prod = productService.update(id, productDTO);
       if(prod!=null){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
       }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unmodified product");

    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteByiD(@PathVariable String id) {
        Optional<Product> prod = productService.deleteById(id);
        if(prod.isPresent()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Product not found");

    }
}
