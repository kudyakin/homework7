package com.kudiukin.homework6.dto;

import com.kudiukin.homework6.model.Shop;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {

    private String name;

    private Double price;

    private Long shopId;

    private Long productId;

    private Shop shop;
}