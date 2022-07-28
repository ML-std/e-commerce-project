package com.ecommerce.searchservice.service;

import com.ecommerce.searchservice.model.Product;

import java.util.List;

public interface SearchService {
    List<Product> searchProducts(List<Product> products, String keyWord);
     List<Product> getSuggestedProducts(List<Product> productList);
}
