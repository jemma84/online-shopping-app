package com.example.onlineshoppingapp.dto;

import com.example.onlineshoppingapp.model.Address;
import com.example.onlineshoppingapp.model.Order;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CustomerDTO implements Serializable {
    private Long id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;

    private String phone;
    @Email
    private String email;

    private Address address;

    private LocalDate subscriptionDate;

    private Boolean enabled;

    private List<CartDTO> carts;

    private List<Order> orders;
}
