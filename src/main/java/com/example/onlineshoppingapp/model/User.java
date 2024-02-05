package com.example.onlineshoppingapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
//@Entity
@Setter
@Getter
//public class User extends Customer {
    public class User {
    /*@Id
    @GeneratedValue*/
    private Long id;
    private String login;
    private String password;
    private String status;
    private LocalDate created;
}
