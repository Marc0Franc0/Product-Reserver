package com.ProductMicroservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
@Document(collection = "products")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
    @Id
    private String id;
    private String name;
    private String description;
    private Double unitPrice;

    public Product(String name,String description,Double unitPrice) {
        this.name = name;
        this.description = description;
        this.unitPrice = unitPrice;
    }
}
