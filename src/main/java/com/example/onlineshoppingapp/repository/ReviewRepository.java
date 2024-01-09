package com.example.onlineshoppingapp.service;

import com.example.onlineshoppingapp.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
