package com.kudiukin.homework6.service;

import com.kudiukin.homework6.dto.CartDto;
import com.kudiukin.homework6.utils.exception.NotFoundException;

import java.util.List;

public interface CartService {

    CartDto createCartByPersonId(Long Id) throws NotFoundException;

    CartDto addProductByProductIdAndCartId(CartDto cartDto) throws NotFoundException;

    CartDto removeProductByProductIdAndCartId(CartDto cartDto) throws NotFoundException;

    void removeAllProductsFromCartById(Long cartId) throws NotFoundException;

    CartDto getCartById(Long id) throws NotFoundException;

    void removeCartById(Long id) throws NotFoundException;

    List<CartDto> getAllCarts();
}
