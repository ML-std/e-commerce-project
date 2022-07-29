package com.ecommerce.infoservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Getter
@Setter
@Embeddable
public class Product {
    private String name;
    private int quantity;
    private BigDecimal price;

}
