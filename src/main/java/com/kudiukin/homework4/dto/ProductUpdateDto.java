package com.kudiukin.homework4.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductUpdateDto {

    private Long productId;

    private String name;

    private Double price;

    private Long shopId;
}
