package com.ecommerce.productservice.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProductBaseDto {

    private String name;
    private String description;
    private int quantity;
    private String imageUrl;

}
