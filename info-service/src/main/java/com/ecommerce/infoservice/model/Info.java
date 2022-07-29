package com.ecommerce.infoservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Info {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    String subject;
    @Column
    String context;

    @Embedded
    PaymentReceipt paymentReceipt;


}
