package com.kudiukin.homework6.controller;

import com.kudiukin.homework6.dto.CartDto;
import com.kudiukin.homework6.dto.PersonDto;
import com.kudiukin.homework6.service.CartService;
import com.kudiukin.homework6.NotFoundException;
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

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteCartView(Model model) {
        model.addAttribute("cart", new CartDto());
        return "deleteCart";
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.DELETE, RequestMethod.POST})
    public String deleteCart(@ModelAttribute("cart") CartDto cartDto) throws NotFoundException {
        cartService.removeCartById(cartDto.getCartId());
        return "deleteCartSuccess";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getAllcarts(Model model) {
        model.addAttribute("all", cartService.getAllCarts());
        return "allCarts";
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getCartByIdView(Model model) {
        model.addAttribute("cartById", new CartDto());
        return "getCart";
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public String getCartById(@ModelAttribute("cartById") CartDto cartDto, Model model) throws NotFoundException {
        CartDto cartById = cartService.getCartById(cartDto.getCartId());
        model.addAttribute("cartById", cartById);
        return "getCartSuccess";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addProductByProductIdAndCartIdView(Model model) {
        model.addAttribute("cart", new CartDto());
        return "addProductToCart";
    }

    @RequestMapping(value = "/add", method = {RequestMethod.PUT, RequestMethod.POST})
    public String addProductByProductIdAndCartId(@ModelAttribute("cart") CartDto cartDto) throws NotFoundException {
        cartService.addProductByProductIdAndCartId(cartDto);
        return "addProductToCartSuccess";
    }

    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public String removeProductByProductIdAndCartIdView(Model model) {
        model.addAttribute("cart", new CartDto());
        return "removeProductFromCart";
    }

    @RequestMapping(value = "/remove", method = {RequestMethod.PUT, RequestMethod.POST})
    public String removeProductByProductIdAndCartId(@ModelAttribute("cart") CartDto cartDto) throws NotFoundException {
        cartService.removeProductByProductIdAndCartId(cartDto);
        return "removeProductFromCartSuccess";
    }

    @RequestMapping(value = "/clean", method = RequestMethod.GET)
    public String removeAllProductsFromCartByIdView(Model model) {
        model.addAttribute("cart", new CartDto());
        return "cleanCart";
    }

    @RequestMapping(value = "/clean", method = RequestMethod.POST)
    public String removeAllProductsFromCartById(@ModelAttribute("cart") CartDto cartDto) throws NotFoundException {
        cartService.removeAllProductsFromCartById(cartDto.getCartId());
        return "cleanCartSuccess";
    }
}
