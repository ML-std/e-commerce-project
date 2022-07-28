package com.ecommerce.cartservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Cart {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    @Column
    private String ownerEmail;

    @Column
    private boolean active;

    @ElementCollection
    private List<Product> products;



}
