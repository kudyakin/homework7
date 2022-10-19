package com.kudiukin.homework6.service;

import com.kudiukin.homework6.NotFoundException;
import com.kudiukin.homework6.model.Shop;

import java.util.List;

public interface ShopService {

    Shop createShop(Shop shop);

    void deleteShop(Long shopId) throws NotFoundException;

    Shop getShopById(Long shopId) throws NotFoundException;

    List<Shop> getAllShops();
}
