package com.kudiukin.homework6.controller;

import com.kudiukin.homework6.dto.CartDto;
import com.kudiukin.homework6.service.CartService;
import com.kudiukin.homework6.NotFoundException;
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
    public CartDto createCartByPersonId(@RequestParam Long Id) throws NotFoundException {
        return cartService.createCartByPersonId(Id);
    }

    @PutMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public CartDto addProductByProductIdAndCartId(@RequestBody CartDto cartDto) throws NotFoundException {
        return cartService.addProductByProductIdAndCartId(cartDto);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public CartDto removeProductByProductIdAndCartId(@RequestBody CartDto cartDto) throws NotFoundException {
        return cartService.removeProductByProductIdAndCartId(cartDto);
    }

    @DeleteMapping("/{cartId}/clean")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAllProductsFromCartById(@PathVariable Long cartId) throws NotFoundException {
        cartService.removeAllProductsFromCartById(cartId);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<CartDto> getAllCarts(){
        return cartService.getAllCarts();
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public CartDto getCartById(@RequestParam Long cartId) throws NotFoundException {
        return cartService.getCartById(cartId);
    }

    @DeleteMapping()
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeCartById(@RequestParam Long cartId) throws NotFoundException {
        cartService.removeCartById(cartId);
    }
}
