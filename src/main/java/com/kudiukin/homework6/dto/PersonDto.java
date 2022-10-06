package com.kudiukin.homework6.dto;

import com.kudiukin.homework6.model.Cart;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PersonDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private List<Cart> carts;
}
