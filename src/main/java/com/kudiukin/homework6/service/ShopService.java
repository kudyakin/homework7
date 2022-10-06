package com.kudiukin.homework6.service;

import com.kudiukin.homework6.dto.ShopDto;
import com.kudiukin.homework6.utils.exception.NotFoundException;

import java.util.List;

public interface ShopService {

    ShopDto createShop(ShopDto shopDto);

    void deleteShop(Long shopId) throws NotFoundException;

    ShopDto getShopById(Long shopId) throws NotFoundException;

    List<ShopDto> getAllShops();
}
