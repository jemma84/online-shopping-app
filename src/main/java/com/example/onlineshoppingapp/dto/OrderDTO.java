package com.example.onlineshoppingapp.dto;

import com.example.onlineshoppingapp.enums.OrderStatus;
import com.example.onlineshoppingapp.model.Address;
import com.example.onlineshoppingapp.model.Payment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO implements Serializable {
    private Long id;

    private BigDecimal price;

    private OrderStatus status;

    private Address shipmentAddress;

    private ZonedDateTime shipmentDate;

    private Set<OrderItemDTO> orderItems;

    private PaymentDTO payment;
}
