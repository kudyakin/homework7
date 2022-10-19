package com.kudiukin.homework6.service;

import com.kudiukin.homework6.NotFoundException;
import com.kudiukin.homework6.model.Cart;

import java.util.List;

public interface CartService {

    Cart createCartByPersonId(Long Id) throws NotFoundException;

    Cart addProductByProductIdAndCartId(Long cartId, Long productId) throws NotFoundException;

    Cart removeProductByProductIdAndCartId(Long cartId, Long productId) throws NotFoundException;

    void removeAllProductsFromCartById(Long cartId) throws NotFoundException;

    Cart getCartById(Long id) throws NotFoundException;

    void removeCartById(Long id) throws NotFoundException;

    List<Cart> getAllCarts();
}
