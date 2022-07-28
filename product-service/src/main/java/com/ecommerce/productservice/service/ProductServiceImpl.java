package com.ecommerce.productservice.service;

import com.ecommerce.productservice.dto.ProductBaseDto;
import com.ecommerce.productservice.dto.ProductUpdateDto;
import com.ecommerce.productservice.model.Product;
import com.ecommerce.productservice.repository.ProductRepository;
import com.ecommerce.productservice.util.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    @Override
    public Product add(ProductBaseDto productBaseDto){
        return productRepository.save(productMapper.productDtoToProduct(productBaseDto));
    }

    @Override
    public List<ProductBaseDto> getProducts(){

        return productMapper.productsToProductBaseDtoList(productRepository.findAll());
    }

    @Override
    public ProductBaseDto getProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()){
            throw new EntityNotFoundException("Product not found");
        }

        return productMapper.productToProductBaseDto(product.get());
    }

    @Override
    public Product update(ProductUpdateDto productUpdateDto) {
        Optional<Product> productData = productRepository.findById(productUpdateDto.getId());
        if (productData.isEmpty()){
            throw new EntityNotFoundException("Product not found");
        }
        Product product = productData.get();
        System.out.println(product.getId());
        product.setName(productUpdateDto.getName());
        return productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

}
