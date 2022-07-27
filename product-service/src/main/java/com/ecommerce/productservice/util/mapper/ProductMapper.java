package com.ecommerce.productservice.util.mapper;

import com.ecommerce.productservice.dto.ProductBaseDto;
import com.ecommerce.productservice.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product productDtoToProduct(ProductBaseDto productBaseDto);
}
