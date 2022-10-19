package com.kudiukin.homework6.controller;

import com.kudiukin.homework6.converter.ShopConverter;
import com.kudiukin.homework6.dto.ShopDto;
import com.kudiukin.homework6.service.ShopService;
import com.kudiukin.homework6.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

import static com.kudiukin.homework6.converter.ShopConverter.getShopDtoFromShop;
import static com.kudiukin.homework6.converter.ShopConverter.getShopFromShopDto;

@Controller
@RequestMapping(path="/api/shop")
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createShopView(Model model) {
        model.addAttribute("shop", new ShopDto());
        return "createShop";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createShop(@ModelAttribute("shop") ShopDto shopDto) {
        shopService.createShop(getShopFromShopDto(shopDto));
        return "createShopSuccess";
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getShopByIdView(Model model) {
        model.addAttribute("shopById", new ShopDto());
        return "getShop";
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public String getShopById(@ModelAttribute("shopById") ShopDto shopDto, Model model) throws NotFoundException {
        ShopDto shopById = getShopDtoFromShop(shopService.getShopById(shopDto.getId()));
        model.addAttribute("shopById", shopById);
        return "getShopSuccess";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteShopView(Model model) {
        model.addAttribute("shop", new ShopDto());
        return "deleteShop";
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.DELETE, RequestMethod.POST})
    public String deleteShop(@ModelAttribute("shop") ShopDto shopDto) throws NotFoundException {
        shopService.deleteShop(shopDto.getId());
        return "deleteShopSuccess";
    }

    @GetMapping( "/all")
    public String getAllShops(Model model) {
        model.addAttribute("all", shopService.getAllShops().stream()
                .map(ShopConverter::getShopDtoFromShop).collect(Collectors.toList()));
        return "allShops";
    }
}
