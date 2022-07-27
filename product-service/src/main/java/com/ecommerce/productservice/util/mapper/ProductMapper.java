package com.ecommerce.productservice.util.mapper;

import com.ecommerce.productservice.dto.ProductBaseDto;
import com.ecommerce.productservice.model.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product productDtoToProduct(ProductBaseDto productBaseDto);
    List<ProductBaseDto> productsToProductBaseDtoList(List<Product> products);
    ProductBaseDto productToProductBaseDto(Product product);
}
