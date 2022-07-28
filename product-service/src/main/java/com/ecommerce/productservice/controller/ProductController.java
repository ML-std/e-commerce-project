package com.ecommerce.productservice.controller;

import com.ecommerce.productservice.dto.ProductBaseDto;
import com.ecommerce.productservice.dto.ProductUpdateDto;
import com.ecommerce.productservice.model.Product;
import com.ecommerce.productservice.service.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping(value = "/product-service")
@RestController
public class ProductController {

    private final ProductServiceImpl productService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    public Product addProduct(@RequestBody ProductBaseDto baseDto){
        return productService.add(baseDto);
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<ProductBaseDto> getProducts(){
        return productService.getProducts();
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public ProductBaseDto getProduct(@PathVariable(value = "id") Long id){
        return productService.getProduct(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/name/{name}")
    public ProductBaseDto getProductByName(@PathVariable(value = "name") String name){
        return productService.getProductByName(name);
    }


    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    public Product updateProduct(@RequestBody ProductUpdateDto productUpdateDto){
        return productService.update(productUpdateDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable(value = "id") Long id){
         productService.delete(id);
    }


}
