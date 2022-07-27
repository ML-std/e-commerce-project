package com.ecommerce.productservice.service;

import com.ecommerce.productservice.dto.ProductBaseDto;
import com.ecommerce.productservice.model.Product;
import com.ecommerce.productservice.repository.ProductRepository;
import com.ecommerce.productservice.util.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;
    @Override
    public Product add(ProductBaseDto productBaseDto){
        return productRepository.save(productMapper.productDtoToProduct(productBaseDto));
    }

}
