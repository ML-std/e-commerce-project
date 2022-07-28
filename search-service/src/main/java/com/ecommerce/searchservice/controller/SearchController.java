package com.ecommerce.searchservice.controller;
import com.ecommerce.searchservice.model.Product;
import com.ecommerce.searchservice.service.SearchServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Slf4j
@RequestMapping(value = "search-service")
@RequiredArgsConstructor
@RestController
public class SearchController {
    private final SearchServiceImpl searchService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{key-word}")
    List<Product> searchProducts(@PathVariable(value = "key-word") String keyWord) throws Exception {
        //Should I reach thorough gateway or not (load balancing)
        ResponseEntity<Product[]> productList = new RestTemplate().getForEntity("http://localhost:8765/product-service/", Product[].class);
        if (!productList.hasBody()){
            throw new Exception("Entity Not found");
        }
        List<Product> products = Arrays.asList(Objects.requireNonNull(productList.getBody()));
        return searchService.searchProducts(products,keyWord);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<Product> getSuggestedProducts() throws Exception{
        ResponseEntity<Product[]> productList = new RestTemplate().getForEntity("http://localhost:8765/product-service/", Product[].class);
        if (!productList.hasBody()){
            throw new Exception("Entity Not found");
        }
        List<Product> products = Arrays.asList(Objects.requireNonNull(productList.getBody()));
        return searchService.getSuggestedProducts(products);
    }


}
