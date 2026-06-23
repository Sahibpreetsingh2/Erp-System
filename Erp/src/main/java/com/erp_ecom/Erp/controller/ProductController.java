package com.erp_ecom.Erp.controller;

import com.erp_ecom.Erp.dto.ProductDto;
import com.erp_ecom.Erp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    @Autowired
    private  ProductService productService;

    @GetMapping
    public ResponseEntity<?> getProducts(){

        return ResponseEntity.ok(
                productService.getAll()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(
            @PathVariable Long id){

        return ResponseEntity.ok(
                productService.getById(id)
        );
    }

    @PostMapping
    public ResponseEntity<?> createProduct(
            @RequestBody ProductDto dto){

        return ResponseEntity.ok(
                productService.saveProduct(dto)
        );
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(
            @PathVariable Long id,
            @RequestBody ProductDto dto){

        return ResponseEntity.ok(
                productService.updateProduct(id, dto)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(
            @PathVariable Long id){

        productService.delete(id);

        return ResponseEntity.ok(
                "Product Deleted Successfully"
        );
    }
}