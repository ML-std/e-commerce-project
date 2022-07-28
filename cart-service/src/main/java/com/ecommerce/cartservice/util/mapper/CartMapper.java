package com.ecommerce.cartservice.util.mapper;

import com.ecommerce.cartservice.dto.CartBaseDto;
import com.ecommerce.cartservice.model.Cart;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartMapper {

    Cart cartBaseDtoToCart(CartBaseDto cartBaseDto);
}
