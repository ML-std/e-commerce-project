package com.ecommerce.productservice.service;

import com.ecommerce.productservice.dto.ProductBaseDto;
import com.ecommerce.productservice.dto.ProductUpdateDto;
import com.ecommerce.productservice.model.Product;

import java.util.List;

public interface ProductService {
    Product add(ProductBaseDto productBaseDto);
    List<ProductBaseDto> getProducts();
    ProductBaseDto getProduct(Long id);
    Product update(ProductUpdateDto productUpdateDtoDto);
    void delete(Long id);
}
