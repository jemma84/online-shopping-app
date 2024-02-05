package com.example.onlineshoppingapp.controller;

import com.example.onlineshoppingapp.dto.CartDTO;
import com.example.onlineshoppingapp.model.Cart;
import com.example.onlineshoppingapp.service.CartService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/carts")
public class CartController {
    private final CartService cartService;

    @GetMapping
    public List<CartDTO> findAllCarts() {
        return cartService.findAll();
    }

    @PostMapping("/create")
    public CartDTO createCart(@Valid @RequestBody CartDTO cartDTO) {
        return cartService.create(cartDTO);
    }

    @GetMapping("/id")
    public CartDTO findCartById(@PathVariable("id") Long id) {
        return cartService.findById(id);
    }
    @GetMapping("/active")
    public List<CartDTO> findAllActiveCarts(@RequestParam List<String> statuses) {
        return cartService.findAllCartsInStatuses(statuses);
    }

    @DeleteMapping
    public void deleteCart(@PathVariable("id") Long id) {
        cartService.delete(id);
    }

    @GetMapping("/customer/{userId}")
    public List<CartDTO> getUserActiveCarts(@PathVariable("userId") Long userId) {
        return cartService.getUserActiveCarts(userId);
    }

}
