package com.example.onlineshoppingapp.controller;

import com.example.onlineshoppingapp.dto.OrderDTO;
import com.example.onlineshoppingapp.model.Order;
import com.example.onlineshoppingapp.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/{id}")
    public OrderDTO findById(@PathVariable("id") Long id) {
        return orderService.findById(id);
    }

    @PostMapping
    public OrderDTO create(@RequestBody OrderDTO order) {
        return orderService.create(order);
    }

    @DeleteMapping
    public void delete(@PathVariable("id") Long id) {
        orderService.delete(id);
    }

    /*@GetMapping("/customer/{customerId}")
     public List<OrderDTO> findAllByUser(@PathVariable Long customerId) {
        return orderService.findAllByUser(customerId);
    }*/

    @GetMapping("/exists/{id}")
    public boolean existsById(@PathVariable("id") Long id) {
        return orderService.existsById(id);
    }
}
