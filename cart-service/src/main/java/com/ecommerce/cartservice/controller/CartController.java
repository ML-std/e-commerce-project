package com.ecommerce.cartservice.controller;

import com.ecommerce.cartservice.dto.AddProductDto;
import com.ecommerce.cartservice.dto.CartBaseDto;
import com.ecommerce.cartservice.model.Cart;
import com.ecommerce.cartservice.model.Product;
import com.ecommerce.cartservice.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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
    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    public Cart addToCart(@RequestBody AddProductDto addProductDto){
        ResponseEntity<Product> product = new RestTemplate().getForEntity("http://localhost:8765/product-service/name/" + addProductDto.getProductName(), Product.class);

        return cartService.addProductToCart(product.getBody(),addProductDto.getOwnerEmail());
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{email}")
    public Cart setCartActiveToFalse(@PathVariable(value = "email") String email ){
        return cartService.setCartActiveToFalse(email);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deleteCart(@PathVariable(value = "id") Long id){
        cartService.deleteCart(id);
    }
}
