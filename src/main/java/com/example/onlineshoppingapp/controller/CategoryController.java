package com.example.onlineshoppingapp.controller;

import com.example.onlineshoppingapp.dto.CategoryDTO;
import com.example.onlineshoppingapp.dto.ProductDTO;
import com.example.onlineshoppingapp.model.Category;
import com.example.onlineshoppingapp.service.CategoryService;
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
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryDTO> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public CategoryDTO findById(@PathVariable("id") Long id) {
        return categoryService.findById(id);
    }

    @PostMapping("/create")
    public CategoryDTO create(@RequestBody CategoryDTO category) {
        return categoryService.create(category);
    }

    @DeleteMapping
    public void delete(@PathVariable("id") Long id) {
        categoryService.delete(id);
    }
    @GetMapping("/{categoryId}/products")
    public List<ProductDTO> findProductsByCategory(@PathVariable("categoryId") Long categoryId) {
        return categoryService.findProductsByCategory(categoryId);
    }
}
