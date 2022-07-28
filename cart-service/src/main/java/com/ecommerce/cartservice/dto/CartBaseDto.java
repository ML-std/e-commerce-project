package com.ecommerce.cartservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartBaseDto {
    private String ownerEmail;
    private boolean active;
}
