package com.erp_ecom.Erp.service;


import com.erp_ecom.Erp.dto.OrderDto;
import com.erp_ecom.Erp.entity.Orders;
import com.erp_ecom.Erp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepo;

    public Orders saveOrder(OrderDto orderDto){
        Orders order = new Orders();

        order.setStatus(orderDto.getStatus());
       return orderRepo.save(order);
    }

    public List<Orders> getAll(){
        return orderRepo.findAll();
    }

    public void delete(Long id ){
        orderRepo.deleteById(id);
    }

    public Optional<Orders> findbyId(Long  id){
        return orderRepo.findById(id);
    }
}
