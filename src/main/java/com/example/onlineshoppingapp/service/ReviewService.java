package com.example.onlineshoppingapp.service;

import com.example.onlineshoppingapp.dto.ReviewDTO;
import com.example.onlineshoppingapp.model.Review;
import com.example.onlineshoppingapp.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    public List<ReviewDTO> findAll() {
        return reviewRepository.findAll().stream().map(this::toReviewDTO).collect(Collectors.toList());
    }

    public ReviewDTO findById(Long id) {
        return reviewRepository.findById(id).map(this::toReviewDTO).orElse(null);
    }

    public ReviewDTO create(ReviewDTO reviewDTO) {
        //Review review = new Review(80L, reviewDTO.getTitle(), reviewDTO.getRating(), reviewDTO.getDescription());
        Review savedCustomer = reviewRepository.save(null);
        return toReviewDTO(savedCustomer);
    }

    public void delete(Long id) {
        reviewRepository.deleteById(id);
    }

    public List<ReviewDTO> findReviewsByProductId(Long productId) {
        return reviewRepository.findAllByProductId(productId).stream().map(this::toReviewDTO).collect(Collectors.toList());
    }

    private ReviewDTO toReviewDTO(Review review) {
        return ReviewDTO.builder()
                .id(review.getId())
                .description(review.getDescription())
                .title(review.getTitle())
                .rating(review.getRating())
                .build();
    }
}
