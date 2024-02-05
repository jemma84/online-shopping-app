package com.example.onlineshoppingapp.controller;

import com.example.onlineshoppingapp.dto.CustomerDTO;
import com.example.onlineshoppingapp.model.Customer;
import com.example.onlineshoppingapp.service.CustomerService;
import jakarta.validation.Valid;
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
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;
    @PostMapping
    public CustomerDTO create(@Valid @RequestBody CustomerDTO customer) {
        return customerService.create(customer);
    }
    @GetMapping
    public List<CustomerDTO> findAll() {
        return customerService.findAll();
    }
    @GetMapping("/{id}")
    public CustomerDTO findById(@PathVariable("id") Long id) {
        return customerService.findById(id);
    }
    @DeleteMapping
    public void delete(Long id) {
        customerService.delete(id);
    }
    @GetMapping("/active")
    public List<CustomerDTO> findAllActive() {
        return customerService.findAllActive();
    }
    @GetMapping("/inactive")
    public List<CustomerDTO> findAllInactive() {
        return customerService.findAllInactive();
    }
}
