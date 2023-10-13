package com.ProductMicroservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Value("${app.testProp}")
    private String testProp;
    @GetMapping
    public String getTestProp(){
        return this.testProp;
    }
}
