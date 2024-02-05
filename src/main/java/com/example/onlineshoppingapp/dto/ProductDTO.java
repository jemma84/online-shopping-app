package com.example.onlineshoppingapp.dto;

import com.example.onlineshoppingapp.enums.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ProductDTO implements Serializable {
    private Long id;

    private  String name;

    private BigDecimal price;

    private int quantity;

    private ProductStatus status;

    private int salesCounter;

    private List<ReviewDTO> reviews;

    private Long categoryId;
}
