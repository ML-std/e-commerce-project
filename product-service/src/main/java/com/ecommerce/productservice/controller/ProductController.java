package com.ecommerce.productservice.controller;

import com.ecommerce.productservice.dto.ProductBaseDto;
import com.ecommerce.productservice.model.Product;
import com.ecommerce.productservice.service.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping(value = "/product-service")
@RestController
public class ProductController {

    private final ProductServiceImpl productService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    public Product addProduct( @RequestBody ProductBaseDto baseDto){

        return productService.add(baseDto);
    }


}
