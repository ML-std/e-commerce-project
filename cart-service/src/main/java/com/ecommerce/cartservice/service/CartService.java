package com.ecommerce.cartservice.service;


import com.ecommerce.cartservice.dto.CartBaseDto;
import com.ecommerce.cartservice.model.Cart;
import com.ecommerce.cartservice.model.Product;

public interface CartService {


    Cart initializeCart(CartBaseDto cartBaseDto);
    Cart findByEmail(String email) throws Exception;

    Cart addProductToCart(Product product, String ownerEmail);
}
