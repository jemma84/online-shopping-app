package com.example.onlineshoppingapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@Embeddable
public class Address {
    @Column(name = "address_1")
    private String address1;
    @Column(name = "city")
    private String city;
    @Column(name = "country")
    private String country;
    @Column(name = "postcode")
    private String postcode;

}
