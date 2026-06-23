package com.erp_ecom.Erp.controller;

import com.erp_ecom.Erp.dto.OrderDto;
import com.erp_ecom.Erp.entity.Orders;
import com.erp_ecom.Erp.entity.User;
import com.erp_ecom.Erp.service.OrderService;
import com.erp_ecom.Erp.service.UserService;
import lombok.RequiredArgsConstructor;
//import org.hibernate.query.Order;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    @Autowired
    private  OrderService orderService;

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<?> getOrders(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User user = userService.findByUserName(userName);
        return ResponseEntity.ok(
                orderService.getAll()
        );
    }

    @PostMapping
    public ResponseEntity<?> createOrder(
            @RequestBody OrderDto order){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User user = userService.findByUserName(userName);
        return ResponseEntity.ok(
                orderService.saveOrder(order)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User user = userService.findByUserName(userName);
        orderService.delete(id);
        return ResponseEntity.ok("order Deleted");
    }


}
