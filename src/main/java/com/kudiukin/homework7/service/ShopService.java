package com.kudiukin.homework7.service;

import com.kudiukin.homework7.NotFoundException;
import com.kudiukin.homework7.model.Shop;

import java.util.List;

public interface ShopService {

    Shop createShop(Shop shop);

    void deleteShop(Long shopId) throws NotFoundException;

    Shop getShopById(Long shopId) throws NotFoundException;

    List<Shop> getAllShops();
}
