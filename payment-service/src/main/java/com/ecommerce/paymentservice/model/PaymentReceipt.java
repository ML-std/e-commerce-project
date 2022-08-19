package com.ecommerce.paymentservice.model;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity
public class PaymentReceipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String ownerMail;


    @ElementCollection
    private List<Product> products;

    @Column
    private BigDecimal totalCost;

    @Column
    private boolean paid;
}
