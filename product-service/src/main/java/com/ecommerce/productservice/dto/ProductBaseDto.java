package com.ecommerce.productservice.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProductBaseDto {

    protected String name;
    protected String description;
    protected int quantity;
    protected String imageUrl;

}
