package com.ecommerce.cartservice.service;


import com.ecommerce.cartservice.dto.CartBaseDto;
import com.ecommerce.cartservice.model.Cart;
import com.ecommerce.cartservice.model.Product;

public interface CartService {

    void deleteCart(Long id);
    Cart initializeCart(CartBaseDto cartBaseDto);
    Cart findByEmail(String email) throws Exception;
    Cart setCartActiveToFalse(String email);
    Cart addProductToCart(Product product, String ownerEmail);
}
