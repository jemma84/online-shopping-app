package com.example.onlineshoppingapp.repository;

import com.example.onlineshoppingapp.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;
@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    Stream<Cart> findAllByStatusIn(List<String> statuses);

    //TODO: implement
    Stream<Cart> findAllByStatusInAndCustomerId(List<String> statuses, Long customerId);

}
