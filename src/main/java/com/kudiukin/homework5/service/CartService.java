package com.kudiukin.homework5.service;

import com.kudiukin.homework5.model.Cart;
import com.kudiukin.homework5.utils.exception.NotFoundException;

import java.util.List;

public interface CartService {

    Cart createCartByPersonId(Long id) throws NotFoundException;

    Cart addProductByProductIdAndCartId(Long productId, Long cartId) throws NotFoundException;

    Cart removeProductByProductIdAndCartId(Long productId, Long cartId) throws NotFoundException;

    Long removeAllProductsFromCartById(Long cartId) throws NotFoundException;

    Cart getCartById(Long id) throws NotFoundException;

    Long removeCartById(Long id) throws NotFoundException;

    List<Cart> getAllCarts();
}
