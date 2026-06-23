package com.erp_ecom.Erp.controller;

import com.erp_ecom.Erp.dto.OrderDto;
import com.erp_ecom.Erp.entity.Orders;
import com.erp_ecom.Erp.service.OrderService;
import lombok.RequiredArgsConstructor;
//import org.hibernate.query.Order;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    @Autowired
    private  OrderService orderService;

    @GetMapping
    public ResponseEntity<?> getOrders(){
        return ResponseEntity.ok(
                orderService.getAll()
        );
    }

    @PostMapping
    public ResponseEntity<?> createOrder(
            @RequestBody OrderDto order){
        return ResponseEntity.ok(
                orderService.saveOrder(order)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id) {
        orderService.delete(id);
        return ResponseEntity.ok("order Deleted");
    }


}
