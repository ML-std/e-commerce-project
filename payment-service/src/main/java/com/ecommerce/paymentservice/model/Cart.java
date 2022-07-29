package com.ecommerce.paymentservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter

public class Cart {


    private long id;
    private String ownerEmail;

    private boolean active;

    private List<Product> products;



}
