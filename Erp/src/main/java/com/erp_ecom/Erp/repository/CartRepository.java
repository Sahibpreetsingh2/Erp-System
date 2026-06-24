package com.erp_ecom.Erp.repository;

import com.erp_ecom.Erp.entity.Cart;
import com.erp_ecom.Erp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository
        extends JpaRepository<Cart, Long> {

    List<Cart> findByUser(User user);
}