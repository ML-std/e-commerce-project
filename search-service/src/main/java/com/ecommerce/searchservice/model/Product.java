package com.ecommerce.searchservice.model;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Product implements Comparable<Product> {

    private String name;
    private String description;
    private int quantity;
    private String imageUrl;
    private int clickCount;
    private BigDecimal price;

    @Override
    public int compareTo(Product product) {
        return product.getClickCount() - this.getClickCount();
    }
}
