package com.example.onlineshoppingapp.service;

import com.example.onlineshoppingapp.dto.CustomerDTO;
import com.example.onlineshoppingapp.mapper.CustomerMapper;
import com.example.onlineshoppingapp.model.Customer;
import com.example.onlineshoppingapp.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerDTO create(CustomerDTO customer) {
        Customer savedOrderItem = customerRepository.save(customerMapper.toCustomer(customer));
        return customerMapper.toCustomerDTO(savedOrderItem);
    }

    public List<CustomerDTO> findAll() {
        return customerRepository.findAll().stream().map(customerMapper::toCustomerDTO).collect(Collectors.toList());
    }

    public CustomerDTO findById(Long id) {
        return customerRepository.findById(id).map(customerMapper::toCustomerDTO).orElse(null);
    }

    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    public List<CustomerDTO> findAllActive() {
        return customerRepository.findAllByEnabledIsTrue()
            .stream().map(customerMapper::toCustomerDTO).collect(Collectors.toList());
    }

    public List<CustomerDTO> findAllInactive() {
        return customerRepository.findAllByEnabledIsFalse()
            .stream().map(customerMapper::toCustomerDTO).collect(Collectors.toList());
    }

}
