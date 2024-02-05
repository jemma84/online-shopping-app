package com.example.onlineshoppingapp.repository;

import com.example.onlineshoppingapp.model.Customer;
import com.example.onlineshoppingapp.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findAllByEnabledIsTrue();
    List<Customer> findAllByEnabledIsFalse();

    /*@Query("select o from Order o where o.customer_id = :customerId")
    List<Order> findOrdersByCustomerId(@Param("customerId") Long customerId);*/
}
