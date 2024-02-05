package com.example.onlineshoppingapp.service;

import com.example.onlineshoppingapp.dto.CategoryDTO;
import com.example.onlineshoppingapp.dto.ProductDTO;
import com.example.onlineshoppingapp.mapper.ProductMapper;
import com.example.onlineshoppingapp.model.Category;
import com.example.onlineshoppingapp.repository.CategoryRepository;
import com.example.onlineshoppingapp.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public List<CategoryDTO> findAll() {
        return categoryRepository.findAll().stream().map(this::toCategoryDTO).collect(Collectors.toList());
    }

    public CategoryDTO findById(Long id) {
        return categoryRepository.findById(id).map(this::toCategoryDTO).orElse(null);
    }

    public CategoryDTO create(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.getName()).setDescription(categoryDTO.getDescription());
        Category savedCategory = categoryRepository.save(category);
        return toCategoryDTO(savedCategory);
    }

    //TODO:fix relationship
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }


    public List<ProductDTO> findProductsByCategory(Long categoryId) {
        return productRepository.findAllByCategoryId(categoryId).stream().map(productMapper::toProductDTO).collect(
            Collectors.toList());
    }

    public CategoryDTO toCategoryDTO(Category category) {
        return CategoryDTO.builder()
            .id(category.getId())
            .description(category.getDescription())
            .name(category.getName()).build();
    }
}
