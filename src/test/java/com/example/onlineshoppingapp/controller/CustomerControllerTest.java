package com.example.onlineshoppingapp.controller;

import com.example.onlineshoppingapp.dto.CustomerDTO;
import com.example.onlineshoppingapp.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CustomerController.class)
public class CustomerControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private CustomerService customerService;

    @Test
    void find_all_customers_ok() throws Exception {
        mockMvc.perform(get("/customers")).andExpect(status().isOk());
    }

    @Test
    void create_customer_ok() throws Exception {
        CustomerDTO customerDTO = CustomerDTO.builder().firstName("Bender").lastName("Rodrigez").email("bender@gmail.com").build();
        when(customerService.create(customerDTO)).thenReturn(customerDTO);
        mockMvc.perform(post("/customers")
                        .content(objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
    }

}
