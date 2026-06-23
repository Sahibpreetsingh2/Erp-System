package com.erp_ecom.Erp.repository;

import com.erp_ecom.Erp.entity.Orders;
import jakarta.persistence.criteria.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository
        extends JpaRepository<Orders, Long> {


//    Optional<Order> findById(Long Id);
//
////    void deleteById(Order order);
//    void deleteById(Long Id);
}