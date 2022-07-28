package com.ecommerce.searchservice.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product implements Comparable<Product> {

    private String name;
    private String description;
    private int quantity;
    private String imageUrl;
    private int clickCount;

    @Override
    public int compareTo(Product o) {
        return o.getClickCount() - this.getClickCount();
    }
}
