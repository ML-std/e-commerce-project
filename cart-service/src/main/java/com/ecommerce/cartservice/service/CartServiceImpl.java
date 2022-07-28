package com.ecommerce.cartservice.service;

import com.ecommerce.cartservice.dto.CartBaseDto;
import com.ecommerce.cartservice.model.Cart;
import com.ecommerce.cartservice.repository.CartRepository;
import com.ecommerce.cartservice.util.mapper.CartMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CartServiceImpl implements CartService{

    private final CartRepository cartRepository;
    private final CartMapper mapper;
    @Override
    public Cart initializeCart(CartBaseDto cartBaseDto) {

        return cartRepository.save(mapper.cartBaseDtoToCart(cartBaseDto));
    }

    @Override
    public Cart findByEmail(String email){
        Optional<Cart> cart = cartRepository.findFirstByOwnerEmailAndActiveTrue(email);
        if (cart.isEmpty()){
                throw new EntityNotFoundException("Entity is null");
        }
        return cart.get();
    }
}
