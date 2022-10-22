package com.kudiukin.homework7.controller;

import com.kudiukin.homework7.converter.CartConverter;
import com.kudiukin.homework7.dto.CartDto;
import com.kudiukin.homework7.dto.PersonDto;
import com.kudiukin.homework7.service.CartService;
import com.kudiukin.homework7.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

import static com.kudiukin.homework7.converter.CartConverter.convertCartModel2CartDto;

@Controller
@RequestMapping(path="/api/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createCart(@ModelAttribute("person") PersonDto personDto) throws NotFoundException {
        cartService.createCartByPersonId(personDto.getId());
        return "/cart/createCartSuccess";
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.DELETE, RequestMethod.POST})
    public String deleteCart(@ModelAttribute("cart") CartDto cartDto) throws NotFoundException {
        cartService.removeCartById(cartDto.getCartId());
        return "/cart/deleteCartSuccess";
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public String getCartById(@ModelAttribute("cartById") CartDto cartDto, Model model) throws NotFoundException {
        CartDto cartById = convertCartModel2CartDto(cartService.getCartById(cartDto.getCartId()));
        model.addAttribute("cartById", cartById);
        return "/cart/getCartSuccess";
    }

    @RequestMapping(value = "/add", method = {RequestMethod.PUT, RequestMethod.POST})
    public String addProductByProductIdAndCartId(@ModelAttribute("cart") CartDto cartDto) throws NotFoundException {
        cartService.addProductByProductIdAndCartId(cartDto.getCartId(), cartDto.getProductId());
        return "/cart/addProductToCartSuccess";
    }

    @RequestMapping(value = "/remove", method = {RequestMethod.PUT, RequestMethod.POST})
    public String removeProductByProductIdAndCartId(@ModelAttribute("cart") CartDto cartDto) throws NotFoundException {
        cartService.removeProductByProductIdAndCartId(cartDto.getCartId(), cartDto.getProductId());
        return "/cart/removeProductFromCartSuccess";
    }

    @RequestMapping(value = "/clean", method = RequestMethod.POST)
    public String removeAllProductsFromCartById(@ModelAttribute("cart") CartDto cartDto) throws NotFoundException {
        cartService.removeAllProductsFromCartById(cartDto.getCartId());
        return "/cart/cleanCartSuccess";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createCartView(Model model) {
        model.addAttribute("person", new PersonDto());
        model.addAttribute("cart", new CartDto());
        return "/cart/createCart";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteCartView(Model model) {
        model.addAttribute("cart", new CartDto());
        return "/cart/deleteCart";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getAllСarts(Model model) {
        model.addAttribute("all", cartService.getAllCarts().stream()
                .map(CartConverter::convertCartModel2CartDto).collect(Collectors.toList()));
        return "/cart/allCarts";
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getCartByIdView(Model model) {
        model.addAttribute("cartById", new CartDto());
        return "/cart/getCart";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addProductByProductIdAndCartIdView(Model model) {
        model.addAttribute("cart", new CartDto());
        return "/cart/addProductToCart";
    }

    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public String removeProductByProductIdAndCartIdView(Model model) {
        model.addAttribute("cart", new CartDto());
        return "/cart/removeProductFromCart";
    }

    @RequestMapping(value = "/clean", method = RequestMethod.GET)
    public String removeAllProductsFromCartByIdView(Model model) {
        model.addAttribute("cart", new CartDto());
        return "/cart/cleanCart";
    }
}
