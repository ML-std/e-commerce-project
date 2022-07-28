package com.ecommerce.cartservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddProductDto {
    private String ownerEmail;
    private String productName;
}
