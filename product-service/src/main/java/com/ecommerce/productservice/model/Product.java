package com.ecommerce.productservice.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private int quantity;

    @Column
    private String imageUrl;
    @Column
    private int clickCount;
    @Column
    private BigDecimal price;


}
