package com.kudiukin.homework6.controller;

import com.kudiukin.homework6.dto.CartDto;
import com.kudiukin.homework6.dto.PersonDto;
import com.kudiukin.homework6.service.CartService;
import com.kudiukin.homework6.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/api/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createCartView(Model model) {
        model.addAttribute("person", new PersonDto());
        model.addAttribute("cart", new CartDto());
        return "createCart";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createCart(@ModelAttribute("person") PersonDto personDto) throws NotFoundException {
        cartService.createCartByPersonId(personDto.getId());
        return "createCartSuccess";
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

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getAllcarts(Model model) {
        model.addAttribute("all", cartService.getAllCarts());
        return "allCarts";
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
