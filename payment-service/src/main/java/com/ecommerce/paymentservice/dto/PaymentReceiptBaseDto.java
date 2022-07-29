package com.ecommerce.paymentservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentReceiptBaseDto {
    private String ownerEmail;
    private boolean paid;
}
