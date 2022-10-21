package com.kudiukin.homework6.converter;

import com.kudiukin.homework6.dto.CartDto;
import com.kudiukin.homework6.model.Cart;

public final class CartConverter {

    public static CartDto convertCartModel2CartDto(Cart cart) {
        CartDto cartDto = new CartDto();
        cartDto.setCartId(cart.getCartId());
        cartDto.setPerson(cart.getPerson());
        cartDto.setProducts(cart.getProducts());
        cartDto.setSum(cart.getSum());
        return cartDto;
    }
}
