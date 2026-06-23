package com.erp_ecom.Erp.controller;

import com.erp_ecom.Erp.dto.ProductCategoryDto;
import com.erp_ecom.Erp.entity.ProductCategory;
import com.erp_ecom.Erp.service.ProductCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product-categories")
@RequiredArgsConstructor
public class ProductCategoryController {

    @Autowired
    private  ProductCategoryService categoryService;

    @GetMapping
    public ResponseEntity<?> getCategories() {

        return ResponseEntity.ok(
                categoryService.getAll()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                categoryService.getById(id)
        );
    }

    @PostMapping
    public ResponseEntity<?> createCategory(
            @RequestBody ProductCategoryDto dto) {

        return ResponseEntity.ok(
                categoryService.saveCategory(dto)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(
            @PathVariable Long id,
            @RequestBody ProductCategoryDto dto) {

        ProductCategory updatedCategory =
                categoryService.updateCategory(id, dto);

        if(updatedCategory != null) {
            return ResponseEntity.ok(updatedCategory);
        }

        return ResponseEntity.badRequest()
                .body("Category Not Found");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(
            @PathVariable Long id) {

        categoryService.delete(id);

        return ResponseEntity.ok(
                "Category Deleted Successfully"
        );
    }
}