package com.example.onlineshoppingapp.service;

import com.example.onlineshoppingapp.dto.OrderDTO;
import com.example.onlineshoppingapp.mapper.OrderMapper;
import com.example.onlineshoppingapp.model.Order;
import com.example.onlineshoppingapp.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderDTO findById(Long id) {
        return orderRepository.findById(id).map(orderMapper::toOrderDTO).orElse(null);
    }

    public OrderDTO create(OrderDTO order) {
        Order savedOrder = orderRepository.save(orderMapper.toOrder(order));
        return orderMapper.toOrderDTO(savedOrder);
    }

    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    //TODO: check repository method
    /*public List<OrderDTO> findAllByUser(Long customerId) {
        return orderRepository.findOrdersByCustomerId(customerId).stream().map(orderMapper::toOrderDTO).collect(
            Collectors.toList());
    }*/

    public boolean existsById(Long id) {
        return orderRepository.existsById(id);
    }
}
