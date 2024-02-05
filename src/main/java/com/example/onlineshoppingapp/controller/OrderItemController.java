package com.example.onlineshoppingapp.controller;

import com.example.onlineshoppingapp.dto.OrderItemDTO;
import com.example.onlineshoppingapp.model.OrderItem;
import com.example.onlineshoppingapp.service.OrderItemService;
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
@RequestMapping("/orderitems")
public class OrderItemController {
    private final OrderItemService orderItemService;

    @GetMapping("/{id}")
    public OrderItemDTO findById(@PathVariable Long id) {
        return orderItemService.findById(id);
    }

    @PostMapping
    public OrderItemDTO create(@RequestBody OrderItemDTO orderItem) {
        return orderItemService.create(orderItem);
    }

    @DeleteMapping
    public void delete(@PathVariable Long id) {
        orderItemService.delete(id);
    }
    @GetMapping("/order/{orderId}")
    public List<OrderItemDTO> findByOrderId(@PathVariable Long orderId) {
        return orderItemService.findByOrderId(orderId);
    }
}
