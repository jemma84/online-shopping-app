package com.example.onlineshoppingapp.repository;

import com.example.onlineshoppingapp.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query("select p from Product p where p.id = :productId")
    List<Review> findAllByProductId(Long productId);
}
