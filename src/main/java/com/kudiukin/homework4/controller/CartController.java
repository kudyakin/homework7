package com.kudiukin.homework4.controller;

import com.kudiukin.homework4.dto.CartDto;
import com.kudiukin.homework4.model.Cart;
import com.kudiukin.homework4.service.CartService;
import com.kudiukin.homework4.utils.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public Cart createCartByPersonId(@RequestParam Long id) throws NotFoundException {
        return cartService.createCartByPersonId(id);
    }

    @PutMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public Cart addProductByProductIdAndCartId(@RequestBody CartDto cartDto) throws NotFoundException {
        return cartService.addProductByProductIdAndCartId(cartDto.getProductId(), cartDto.getCartId());
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Cart removeProductByProductIdAndCartId(@RequestBody CartDto cartDto) throws NotFoundException {
        return cartService.removeProductByProductIdAndCartId(cartDto.getProductId(), cartDto.getCartId());
    }

    @DeleteMapping("/{cartId}/clean")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAllProductsFromCartById(@PathVariable Long cartId) throws NotFoundException {
        cartService.removeAllProductsFromCartById(cartId);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Cart> getAllCarts(){
        return cartService.getAllCarts();
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Cart getCartById(@RequestParam Long cartId) throws NotFoundException {
        return cartService.getCartById(cartId);
    }

    @DeleteMapping()
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Long removeCartById(@RequestParam Long cartId) throws NotFoundException {
        cartService.removeCartById(cartId);
        return cartId;
    }
}
