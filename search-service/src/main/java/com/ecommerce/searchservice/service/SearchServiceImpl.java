package com.ecommerce.searchservice.service;

import com.ecommerce.searchservice.model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService{

    @Value("${suggested-product-count}")
    private int suggestedProductCount;

    @Override
    public List<Product> searchProducts(List<Product> products, String keyWord) {
        List<Product> searchedProducts = new ArrayList<>();
        for (Product product: products) {
            if (product.getName().contains(keyWord)){
                searchedProducts.add(product);
            }
        }
        Collections.sort(searchedProducts);
        return searchedProducts;
    }

    @Override
    public List<Product> getSuggestedProducts(List<Product> productList){
        Collections.sort(productList);
        productList = productList.stream().limit(suggestedProductCount).toList();
        return productList;
    }


}
