package com.ecommerce.cartservice.controller;

import com.ecommerce.cartservice.dto.CartBaseDto;
import com.ecommerce.cartservice.model.Cart;
import com.ecommerce.cartservice.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping(value = "/cart-service")
@RestController
public class CartController {

    private final CartService cartService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    public Cart initializeCart(@RequestBody CartBaseDto cartBaseDto){
        return cartService.initializeCart(cartBaseDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{email}")

    public Cart getCart(@PathVariable(value = "email") String email) throws Exception {
        return cartService.findByEmail(email);
    }
}
