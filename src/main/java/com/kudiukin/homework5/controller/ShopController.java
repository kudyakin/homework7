package com.kudiukin.homework5.controller;

import com.kudiukin.homework5.model.Shop;
import com.kudiukin.homework5.service.ShopService;
import com.kudiukin.homework5.utils.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/shop")
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public Shop createShop(@RequestBody Shop shop){
        return shopService.createShop(shop);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Shop getShopById(@RequestParam Long shopId) throws NotFoundException {
        return shopService.getShopById(shopId);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Long deleteShop(@RequestParam Long shopId) throws NotFoundException {
        shopService.deleteShop(shopId);
        return shopId;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Shop> getAll() {
        return shopService.getAllShops();
    }

}
