package com.ecommerce.cartservice.model;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
public class Product {
    private String name;
    private String description;
    private int quantity;
    private String imageUrl;
    private int clickCount;
    private BigDecimal price;
}
