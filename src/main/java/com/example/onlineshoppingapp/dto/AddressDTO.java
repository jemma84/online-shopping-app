package com.example.onlineshoppingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO implements Serializable {
    private String address1;

    private String address2;

    private String city;

    private String Country;

    private String postcode;
}
