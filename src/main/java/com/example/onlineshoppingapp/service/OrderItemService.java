package com.example.onlineshoppingapp.service;

import com.example.onlineshoppingapp.dto.OrderItemDTO;
import com.example.onlineshoppingapp.model.OrderItem;
import com.example.onlineshoppingapp.repository.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class OrderItemService {
    private final OrderItemRepository orderItemRepository;

    public OrderItemDTO findById(Long id) {
        return orderItemRepository.findById(id).map(this::toOrderItemDTO)
            .orElse(null);
    }

    public OrderItemDTO create(OrderItemDTO orderItemDTO) {
        OrderItem orderItem = new OrderItem();
        orderItem.setQuantity(orderItemDTO.getQuantity());
        OrderItem savedOrderItem = orderItemRepository.save(orderItem);
        return toOrderItemDTO(savedOrderItem);
    }

    public void delete(Long id) {
        orderItemRepository.deleteById(id);
    }

    public List<OrderItemDTO> findByOrderId(Long orderId) {
        return orderItemRepository.findAllByOrderId(orderId).stream().map(this::toOrderItemDTO).collect(Collectors.toList());
    }

    private OrderItemDTO toOrderItemDTO(OrderItem orderItem) {
        return OrderItemDTO.builder()
            .id(orderItem.getId())
            .quantity(orderItem.getQuantity())
            .orderId(orderItem.getOrder().getId())
            .productId(orderItem.getProduct().getId())
            .build();
    }
}
