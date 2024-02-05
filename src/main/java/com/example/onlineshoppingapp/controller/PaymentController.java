package com.example.onlineshoppingapp.controller;

import com.example.onlineshoppingapp.dto.OrderDTO;
import com.example.onlineshoppingapp.dto.PaymentDTO;
import com.example.onlineshoppingapp.model.Payment;
import com.example.onlineshoppingapp.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping
    public PaymentDTO create(PaymentDTO payment) {
        return paymentService.create(payment);
    }

    @GetMapping
    public List<PaymentDTO> findAll() {
        return paymentService.findAll();
    }
    @GetMapping("/{id}")
    public PaymentDTO findById(@PathVariable Long id) {
        return paymentService.findById(id);
    }
    @DeleteMapping
    public void delete(@PathVariable Long id) {
        paymentService.delete(id);
    }
    @GetMapping("/price")
    public List<PaymentDTO> findByPriceRange(Double value) {
        return paymentService.findByPriceRange(value);
    }
    @GetMapping("/order/{paymentId}")
    public OrderDTO findOrderByPaymentId(@PathVariable Long paymentId) {
        return paymentService.findOrderByPaymentId(paymentId);
    }
}
