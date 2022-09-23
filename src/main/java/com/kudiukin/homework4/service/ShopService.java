package com.kudiukin.homework4.service;

import com.kudiukin.homework4.model.Shop;
import com.kudiukin.homework4.utils.exception.NotFoundException;

import java.util.List;

public interface ShopService {

    Shop createShop(Shop shop);

    Long deleteShop(Long shopId) throws NotFoundException;

    Shop getShopById(Long shopId) throws NotFoundException;

    List<Shop> getAllShops();
}
