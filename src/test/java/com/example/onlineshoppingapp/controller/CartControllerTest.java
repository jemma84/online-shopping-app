package com.example.onlineshoppingapp.controller;

import com.example.onlineshoppingapp.dto.CartDTO;
import com.example.onlineshoppingapp.dto.CustomerDTO;
import com.example.onlineshoppingapp.enums.CartStatus;
import com.example.onlineshoppingapp.service.CartService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(controllers = CartController.class)
public class CartControllerTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private CartService cartService;

    @Test
    void findAllCarts_ok() throws Exception {
        mvc.perform(get("/carts"))
            .andExpect(status().isOk());
    }

    @Test
    void create_cart_ok() throws Exception {
        CartDTO cart = new CartDTO(1L, CartStatus.NEW.name(), new CustomerDTO());

        when(cartService.create(cart)).thenReturn(cart);
        mvc.perform(post("/carts/create")
                .content(objectMapper.writeValueAsString(cart))
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().bytes(objectMapper.writeValueAsBytes(cart)));
    }
}
