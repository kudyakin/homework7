package com.kudiukin.homework4.repository;

import com.kudiukin.homework4.model.Cart;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Getter
public class CartCollection {

    private final Map<Integer, Cart> carts = new HashMap<>();

}
