package com.erp_ecom.Erp.controller;

import com.erp_ecom.Erp.dto.CartDto;
import com.erp_ecom.Erp.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping
    public ResponseEntity<?> addToCart(
            @RequestBody CartDto dto,
            Authentication authentication){

        String email =
                authentication.getName();

        return ResponseEntity.ok(
                cartService.addToCart(dto,email)
        );
    }

    @GetMapping
    public ResponseEntity<?> getCart(
            Authentication authentication){

        String email =
                authentication.getName();

        return ResponseEntity.ok(
                cartService.getCart(email)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCart(
            @PathVariable Long id){

        cartService.deleteCart(id);

        return ResponseEntity.ok(
                "Item Removed From Cart"
        );
    }
}