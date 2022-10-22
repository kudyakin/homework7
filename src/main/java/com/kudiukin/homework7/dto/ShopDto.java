package com.kudiukin.homework7.dto;

import com.kudiukin.homework7.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ShopDto {

    private Long id;
    private String name;
    private String address;
    private List<Product> products;
}
