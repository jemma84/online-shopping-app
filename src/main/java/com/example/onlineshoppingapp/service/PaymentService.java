package com.example.onlineshoppingapp.service;

import com.example.onlineshoppingapp.dto.OrderDTO;
import com.example.onlineshoppingapp.dto.PaymentDTO;
import com.example.onlineshoppingapp.mapper.OrderMapper;
import com.example.onlineshoppingapp.model.Order;
import com.example.onlineshoppingapp.model.Payment;
import com.example.onlineshoppingapp.repository.OrderRepository;
import com.example.onlineshoppingapp.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public PaymentDTO create(PaymentDTO paymentDTO) {
        Payment payment = new Payment(80L, paymentDTO.getStatus(), paymentDTO.getPaypalPaymentId(), paymentDTO.getAmount());
        Payment savedPayment = paymentRepository.save(payment);
        return toPaymentDTO(savedPayment);
    }

    public List<PaymentDTO> findAll() {
        return paymentRepository.findAll().stream().map(this::toPaymentDTO).collect(Collectors.toList());
    }

    public PaymentDTO findById(Long id) {
        return paymentRepository.findById(id).map(this::toPaymentDTO).orElse(null);
    }

    public void delete(Long id) {
        paymentRepository.deleteById(id);
    }

    public List<PaymentDTO> findByPriceRange(Double value) {
        return paymentRepository.findAllByAmountBetween(BigDecimal.ZERO, BigDecimal.valueOf(value))
            .stream().map(this::toPaymentDTO).collect(Collectors.toList());
    }

    public OrderDTO findOrderByPaymentId(Long id) {
        return orderRepository.findById(id).map(orderMapper::toOrderDTO).orElse(null);
    }

    private PaymentDTO toPaymentDTO(Payment payment) {
        return PaymentDTO.builder()
            .id(payment.getId())
            .paypalPaymentId(payment.getPaypalPaymentId())
            .amount(payment.getAmount())
            .build();
    }
}
