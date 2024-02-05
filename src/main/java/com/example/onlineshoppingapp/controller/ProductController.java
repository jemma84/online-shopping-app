package com.example.onlineshoppingapp.controller;

import com.example.onlineshoppingapp.dto.ProductDTO;
import com.example.onlineshoppingapp.model.Product;
import com.example.onlineshoppingapp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<ProductDTO> findAll() {
        return productService.findAll();
    }
    @GetMapping("/{id}")
    public ProductDTO findById(@PathVariable("id") Long id) {
        return productService.findById(id);
    }
    @PostMapping
    public ProductDTO create(@RequestBody ProductDTO product) {
        return productService.create(product);
    }
    @DeleteMapping
    public void delete(@PathVariable("id") Long id) {
        productService.delete(id);
    }
    @GetMapping("/count")
    public long count() {
        return productService.count();
    }
    @GetMapping("products/{categoryId}")
    public List<ProductDTO> findAllByCategoryId(@PathVariable("categoryId") Long categoryId) {
        return productService.findAllByCategoryId(categoryId);
    }
    @GetMapping("/{categoryId}/count")
    public long countByCategoryId(@PathVariable Long categoryId) {
        return productService.countByCategoryId(categoryId);
    }
}
