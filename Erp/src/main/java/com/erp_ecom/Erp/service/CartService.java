package com.erp_ecom.Erp.service;

import com.erp_ecom.Erp.dto.CartDto;
import com.erp_ecom.Erp.entity.Cart;
import com.erp_ecom.Erp.entity.Product;
import com.erp_ecom.Erp.entity.User;
import com.erp_ecom.Erp.repository.CartRepository;
import com.erp_ecom.Erp.repository.ProductRepository;
import com.erp_ecom.Erp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepo;

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private UserRepository userRepo;

    public Cart addToCart(
            CartDto dto,
            String email){

        User user =
                userRepo.findByEmail(email).get();

        Product product =
                productRepo.findById(dto.getProductId()).get();

        Cart cart = new Cart();

        cart.setUser(user);
        cart.setProduct(product);
        cart.setQuantity(dto.getQuantity());

        return cartRepo.save(cart);
    }

    public List<Cart> getCart(String email){

        User user =
                userRepo.findByEmail(email).get();

        return cartRepo.findByUser(user);
    }

    public void deleteCart(Long id){
        cartRepo.deleteById(id);
    }
}