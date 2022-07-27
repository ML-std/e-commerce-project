package com.ecommerce.productservice.service;

import com.ecommerce.productservice.dto.ProductBaseDto;
import com.ecommerce.productservice.model.Product;

public interface ProductService {
    Product add(ProductBaseDto productBaseDto);
}
