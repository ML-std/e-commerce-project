package com.ecommerce.infoservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Embeddable
public class PaymentReceipt {


    @Column(name = "receipt_id")
    private Long id;
    private String ownerEmail;
    @ElementCollection
    private List<Product> products;

    private BigDecimal totalCost;

    private boolean paid;

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Products\n");
        for (Product product: this.products) {
            stringBuilder.append(product.getName()).append(" Quantity: ").append(product.getQuantity()).append(" cost: ")
                    .append(product.getPrice()).append("\n");
        }
        stringBuilder.append("Total Cost: ").append(this.totalCost);

        return stringBuilder.toString();
    }
}
