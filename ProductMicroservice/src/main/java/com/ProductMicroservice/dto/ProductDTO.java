package com.ProductMicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProductDTO {
    private String name;
    private String description;
    private Double unitPrice;

}
