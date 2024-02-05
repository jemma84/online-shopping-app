package com.example.onlineshoppingapp.service;

import com.example.onlineshoppingapp.dto.ProductDTO;
import com.example.onlineshoppingapp.mapper.ProductMapper;
import com.example.onlineshoppingapp.model.Product;
import com.example.onlineshoppingapp.model.Review;
import com.example.onlineshoppingapp.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;


    public List<ProductDTO> findAll() {
        return productRepository.findAll().stream().map(productMapper::toProductDTO).collect(Collectors.toList());
    }

    public ProductDTO findById(Long id) {
        return productRepository.findById(id).map(productMapper::toProductDTO).orElse(null);
    }

    public ProductDTO create(ProductDTO productDTO) {
        Product product = productMapper.toProduct(productDTO);
        product.getReviews().forEach(review -> review.setProduct(product));

        Product savedProduct = productRepository.save(product);
        return productMapper.toProductDTO(savedProduct);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    public long count() {
        return productRepository.count();
    }

    public List<ProductDTO> findAllByCategoryId(Long categoryId) {
        return productRepository.findAllByCategoryId(categoryId).stream().map(productMapper::toProductDTO).collect(Collectors.toList());
    }

    public long countByCategoryId(Long categoryId) {
        return productRepository.countAllByCategoryId(categoryId);
    }
}
