package com.kudiukin.homework4.service;

import com.kudiukin.homework4.model.Cart;
import com.kudiukin.homework4.utils.exception.NotFoundException;

import java.util.List;

public interface CartService {

    Cart createCartByPersonId(Integer id) throws NotFoundException;

    Cart addProductByProductIdAndCartId(Integer productId, Integer cartId) throws NotFoundException;

    Cart removeProductByProductIdAndCartId(Integer productId, Integer cartId) throws NotFoundException;

    void removeAllProductsFromCartById(Integer cartId) throws NotFoundException;

    List<Cart> getAllByPersonId(Integer id) throws NotFoundException;

    Cart getCartById(Integer id) throws NotFoundException;

    void removeCartById(Integer id) throws NotFoundException;
}
