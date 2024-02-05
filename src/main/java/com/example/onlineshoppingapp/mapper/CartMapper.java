package com.example.onlineshoppingapp.mapper;

import com.example.onlineshoppingapp.dto.CartDTO;
import com.example.onlineshoppingapp.model.Cart;
import org.mapstruct.Mapper;

@Mapper
public interface CartMapper {
    Cart toCart(CartDTO cartDTO);

    CartDTO toCartDto(Cart cart);
}
