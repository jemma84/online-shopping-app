package com.example.onlineshoppingapp.controller;

import com.example.onlineshoppingapp.dto.ReviewDTO;
import com.example.onlineshoppingapp.model.Review;
import com.example.onlineshoppingapp.service.ReviewService;
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
@RequestMapping("/review")
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping
    public List<ReviewDTO> findAll() {
        return reviewService.findAll();
    }
    @GetMapping("/{id}")
    public ReviewDTO findById(@PathVariable("id") Long id) {
        return reviewService.findById(id);
    }
    @PostMapping
    public ReviewDTO create(@RequestBody ReviewDTO reviewDTO) {
        return reviewService.create(reviewDTO);
    }
    @DeleteMapping
    public void delete(Long id) {
        reviewService.delete(id);
    }
    @GetMapping("/reviews/{productId}")
    private List<ReviewDTO> findReviewsByProductId(@PathVariable Long productId) {
        return reviewService.findReviewsByProductId(productId);
    }
}
