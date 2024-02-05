package com.example.onlineshoppingapp.mapper;

import com.example.onlineshoppingapp.dto.ProductDTO;
import com.example.onlineshoppingapp.model.Product;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {
    ProductDTO toProductDTO(Product product);

    Product toProduct(ProductDTO productDTO);
}
