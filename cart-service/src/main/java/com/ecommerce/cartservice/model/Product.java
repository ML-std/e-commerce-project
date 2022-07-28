package com.ecommerce.cartservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.math.BigDecimal;
import java.util.Objects;

@Embeddable
@Getter
@Setter
public class Product {
    private String name;
    private String description;
    private int quantity;
    private String imageUrl;
    private int clickCount;
    private BigDecimal price;

    @Override
    public boolean equals(Object o){
        Product product = (Product) o;
        return Objects.equals(product.getName(), this.name);
    }
}
