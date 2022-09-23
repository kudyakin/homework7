package com.kudiukin.homework4.service;

import com.kudiukin.homework4.model.Cart;
import com.kudiukin.homework4.utils.exception.NotFoundException;

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
