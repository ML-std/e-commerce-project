package com.ecommerce.productservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
public class ProductBaseDto {

    protected String name;
    protected String description;
    protected int quantity;
    protected String imageUrl;
    protected int clickCount;
    protected BigDecimal price;


}
