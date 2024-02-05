package com.example.onlineshoppingapp.mapper;

import com.example.onlineshoppingapp.dto.OrderDTO;
import com.example.onlineshoppingapp.dto.OrderItemDTO;
import com.example.onlineshoppingapp.model.Order;
import com.example.onlineshoppingapp.model.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface OrderMapper {
    @Mapping(target = "id", source = "order.id")
    OrderDTO toOrderDTO(Order order);

    @Mapping(target = "productId", source = "product.id")
    @Mapping(target = "orderId", source = "order.id")
    OrderItemDTO toOrderItemDTO(OrderItem orderItem);

    Order toOrder(OrderDTO orderDTO);
}
