package com.example.onlineshoppingapp.mapper;

import com.example.onlineshoppingapp.dto.CustomerDTO;
import com.example.onlineshoppingapp.model.Customer;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    CustomerDTO toCustomerDTO(Customer customer);
}
