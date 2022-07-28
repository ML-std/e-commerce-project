package com.ecommerce.cartservice.service;

import com.ecommerce.cartservice.dto.CartBaseDto;
import com.ecommerce.cartservice.model.Cart;
import com.ecommerce.cartservice.model.Product;
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
    public void deleteCart(Long id) {
        cartRepository.deleteById(id);
    }

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

    @Override
    public Cart setCartActiveToFalse(String email) {
        Cart cart = findByEmail(email);
        cart.setActive(false);
        return cartRepository.save(cart);
    }

    @Override
    public Cart addProductToCart(Product product, String ownerEmail) {
        product.setQuantity(0);
        Cart cart = findByEmail(ownerEmail);
        if (cart.getProducts().contains(product)) {
            int index = cart.getProducts().indexOf(product);

            cart.getProducts().get(index).setQuantity(cart.getProducts().get(index).getQuantity() + 1);
            cart.getProducts().get(index).setPrice(product.getPrice().multiply(cart.getProducts()
                    .get(index).getPrice()));
        }
        else {
            product.setQuantity(1);
            cart.getProducts().add(product);

        }
        return cartRepository.save(cart);
    }
}
