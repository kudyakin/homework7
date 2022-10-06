package com.kudiukin.homework6.converter;

import com.kudiukin.homework6.dto.CartDto;
import com.kudiukin.homework6.model.Cart;

public final class CartConverter {

    public static CartDto getCartDtoFromCart(Cart cart) {
        CartDto cartDto = new CartDto();
        cartDto.setCartId(cart.getCartId());
        cartDto.setPerson(cart.getPerson());
        cartDto.setProducts(cart.getProducts());
        cartDto.setSum(cart.getSum());
        return cartDto;
    }

    public static Cart getCartFromCartDto(CartDto cartDto) {
        Cart cart = new Cart();
        cart.setCartId(cartDto.getCartId());
        cart.setPerson(cartDto.getPerson());
        cart.setProducts(cartDto.getProducts());
        cart.setSum(cartDto.getSum());
        cart.setProducts(cartDto.getProducts());
        return cart;
    }
}
