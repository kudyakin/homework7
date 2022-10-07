package com.kudiukin.homework6.service;

import com.kudiukin.homework6.dto.ShopDto;
import com.kudiukin.homework6.repository.ShopRepository;
import com.kudiukin.homework6.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.kudiukin.homework6.converter.ShopConverter.*;

@Service
public class ShopServiceImpl implements ShopService{
    private final ShopRepository shopRepository;

    public ShopServiceImpl(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    @Override
    public ShopDto createShop(ShopDto shopDto) {
        return getShopDtoFromShop(shopRepository.save(getShopFromShopDto(shopDto)));
    }

    @Override
    public void deleteShop(Long shopId) throws NotFoundException {
        if (shopRepository.existsById(shopId)) {
            shopRepository.deleteById(shopId);
        } else {
            throw new NotFoundException("Shop with ID #" + shopId + " is not found");
        }
    }

    @Override
    public ShopDto getShopById(Long shopId) throws NotFoundException {
        if (shopRepository.findById(shopId).isPresent()) {
            return getShopDtoFromShop(shopRepository.findById(shopId).get());
        } else {
            throw new NotFoundException("Shop with ID #" + shopId + " is not found");
        }
    }

    @Override
    public List<ShopDto> getAllShops() {
        List<ShopDto> shopDtoList = new ArrayList<>();
        shopRepository.findAll().forEach(shop -> shopDtoList.add(getShopDtoFromShop(shop)));
        return shopDtoList;
    }
}
